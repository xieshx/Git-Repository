package com.neu.ms.component;

import com.neu.ms.common.api.CommonResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在前后端分离的情况下，需要屏蔽掉重定向的登录页面并返回统一的json格式的返回体。
 * 而实现这一功能的核心就是实现AuthenticationEntryPoint
 * 并在WebSecurityConfig中注入，然后在configure(HttpSecurity http)方法中。
 * AuthenticationEntryPoint主要是用来处理匿名用户访问无权限资源时的异常（即未登录，或者登录状态过期失效）
 */
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // AuthenticationException常见子类如下：
    // 一、AccountStatusException用户状态异常它包含如下子类：
    //      1.AccountExpiredException（账户过期）
    //      2.LockedException（账户锁定）
    //      3.DisabledException（账户不可用）
    //      4.CredentialsExpiredException（证书过期）
    // 二、UsernameNotFoundException
    // 三、BadCredentialsException
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
