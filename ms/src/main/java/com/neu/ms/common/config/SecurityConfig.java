package com.neu.ms.common.config;

import com.neu.ms.component.CustomizeAccessDeniedHandler;
import com.neu.ms.component.CustomizeAuthenticationEntryPoint;
import com.neu.ms.component.JwtAuthenticationTokenFilter;
import com.neu.ms.dto.AdminUserDetails;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.service.AdminService;
import com.neu.ms.service.impl.AdminServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 日志记录器
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

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
                // 关闭csrf
                // 在Security的默认拦截器里，默认会开启CSRF处理，判断请求post是否携带了token，如果没有就拒绝访问（403、401）。
                // 在请求为(GET|HEAD|TRACE|OPTIONS)时，不会开启CSRF处理，
                .csrf().disable()
                // 关闭HttpSession（STATELESS），设置为无状态连接
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 请求授权
                .authorizeRequests()
                // 登录页面随便访问
                .antMatchers("/admin/login").permitAll()
                // .antMatchers("/admin/login").permitAll()
                // 跨域请求先进行一次options（这是浏览器给我们加上的）
                // options请求方法主要有两个作用：
                // 1.获取服务器支持的HTTP请求方法
                // 2.检查服务器的性能 跨域请求中，
                // options请求是浏览器自发起的preflight request(预检请求)，以检测实际请求是否可以被浏览器接受。
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                //其他请求需要认证
                .anyRequest().authenticated();

        //关闭页面缓存
        http.headers().cacheControl();

        // TODO:配置自定义的验证过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

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

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    //获取用户登录信息
    //用UserDetailsService的方法去加载自定义的UserDetails
    @Bean
    public UserDetailsService userDetailsService() {
        // UserDetailsService中只有一个方法，可以用lambda直接返回一个UserDetails
        return username -> {
            MsAdmin admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                // TODO：在这里需要把从数据中获取到的该用户的权限构造进去，修改AdminUserDetails构造器
                return new AdminUserDetails(admin);
            }
            // UsernameNotFoundException会转换成其父类AuthenticationException
            // 在AuthenticationEntryPoint中抛出，并直接返回前端数据
            throw new UsernameNotFoundException("用户名或密码错误！");
        };
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行所有请求，相当于security功能
        // web.ignoring().antMatchers("/**");
        //TODO:放行swagger，将路径都加入到配置文件的白名单当中
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
