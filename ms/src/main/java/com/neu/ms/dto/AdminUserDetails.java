package com.neu.ms.dto;

import com.neu.ms.mbg.model.MsAdmin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * UserDetails有一个默认实现类：User
 * 继承UserDetails接口，实现SpringSecurity需要的用户详情
 * 可以自定义自己需要的验证属性
 * Security这个框架不管你的应用时怎么存储用户和权限信息的。只要你取出来的时候把它包装成一个UserDetails对象给它用就行
 * 封装好这个类，丢给UserDetailsService认证即可
 */
public class AdminUserDetails implements UserDetails {
    //自定义验证账户名密码即可
    private MsAdmin admin;

    public AdminUserDetails(MsAdmin admin) {
        this.admin = admin;
    }

    //返回当前用户的权限集
    //TODO：数据库增加权限表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //用户加密过的密码
    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    //应用内的唯一用户名
    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    //账户是否过期 true:未过期 false：已过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户是否锁定 true:未锁定 false：已锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //账户凭证是否过期 true:未过期 false：已过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //账户是否可用
    @Override
    public boolean isEnabled() {
        return admin.getStatus();
    }

    public String getAvatarAddress(){
        return admin.getAvatarAddress();
    }
}
