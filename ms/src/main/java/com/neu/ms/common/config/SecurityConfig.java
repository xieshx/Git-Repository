package com.neu.ms.common.config;

import com.neu.ms.component.CustomizeAccessDeniedHandler;
import com.neu.ms.component.CustomizeAuthenticationEntryPoint;
import com.neu.ms.dto.AdminUserDetails;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AdminService adminService;

    @Resource
    private CustomizeAccessDeniedHandler customizeAccessDeniedHandler;

    @Resource
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;


    //http相关的配置，包括登入登出、异常处理、会话管理等
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭csrf
                .csrf().disable()
                //关闭HttpSession（STATELESS）
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //请求授权
                .authorizeRequests()
                //登录页面随便访问
                .antMatchers("/login").permitAll()
                //跨域请求先进行一次option
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                //其他请求需要认证
                .anyRequest().authenticated();

        //关闭缓存
        http.headers().cacheControl();

        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(customizeAccessDeniedHandler)
                .authenticationEntryPoint(customizeAuthenticationEntryPoint);
    }

    //配置认证规则，加入UserDetailsService和密码编码器
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    //创建密码编译器，注入容器中
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //获取用户登录信息
    //用UserDetailsService的方法去加载自定义的UserDetails
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            MsAdmin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                return new AdminUserDetails(admin);
            }
            throw new UsernameNotFoundException("用户名或密码错误！");
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行所有请求，相当于security功能
        // web.ignoring().antMatchers("/**");
        //放行swagger
        web.ignoring().antMatchers(HttpMethod.GET,
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html/**",
                "/webjars/**"
        );
    }

}
