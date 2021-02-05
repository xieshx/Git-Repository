package com.neu.ms.common.config;

import com.neu.ms.dto.AdminUserDetails;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.service.AdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AdminService adminService;

    //TODO:授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    //认证规则，加入UserDetailsService和密码编码器
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    //获取用户登录信息
    //用UserDetailsService的方法去加载自定义的UserDetails
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            MsAdmin admin = adminService.getAdminByUsername(username);
            if (admin!=null){
                return new AdminUserDetails(admin);
            }
            throw new UsernameNotFoundException("用户名或密码错误！");
        };
    }

    //关闭SpringSecurity
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**");
    }

}
