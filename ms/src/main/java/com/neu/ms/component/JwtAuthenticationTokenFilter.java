package com.neu.ms.component;

import com.neu.ms.common.utils.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义请求过滤器
 * OncePerRequestFilter：它能够确保在一次请求中只通过一次filter，而不需要重复的执行
 * 在spring中，filter都默认继承OncePerRequestFilter
 * SpringSecurity非常容易出现通一个filter被执行多遍，原因尚未探寻
 * OncePerRequestFilter是为了兼容不同的web 容器，也就是说其实不是所有的容器都过滤一次
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private JwtTokenUtils jwtTokenUtils;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 去请求头获取Authorization中的token内容
        String authHeader = httpServletRequest.getHeader(this.tokenHeader);

        // 若token存在且以Bearer 开头
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {

            // 将token的头去掉，即Bearer （包括空格），获得token体
            String authToken = authHeader.substring(this.tokenHead.length());

            // 从token中读取出用户名
            String username = jwtTokenUtils.getUserNameFromToken(authToken);
            LOGGER.info("checking username:{}", username);

            // 若用户名不为空且
            // SecurityContextHolder是SpringSecurity最基本的组件，是一个工具类，仅提供一些静态方法，这个工具类的目的是用来保存应用程序中当前使用人的安全上下文。
            // 每个用户都会有一个上下文（SecurityContext），存储在SecurityContextHolder中
            // SecurityContextHolder存储了当前与系统交互的用户的信息（Authentication认证信息），
            // 若存在该用户并且该用户没有登录状态
            // TODO：登录状态总是为空，这个问题的原因的是在用Spring Security加载权限的时候没有加载到，一般是手动调用重写的loadUserByUsername方法却没有赋予权限导致的
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // 从数据库获取信息并加载UserDetails
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                // 判断token有效性
                if (jwtTokenUtils.validateToken(authToken, userDetails)) {

                    // 前端传来的username和password首先会进入UsernamePasswordAuthenticationToken验证(Authentication)
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    LOGGER.info("authenticated user:{}", username);
                    
                    // 建立安全上下文，设置为已登录
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}