package com.neu.ms.service.impl;

import com.neu.ms.common.utils.JwtTokenUtils;
import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.dto.AdminRegisterParam;
import com.neu.ms.mbg.mapper.MsAdminMapper;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.mbg.model.MsAdminExample;
import com.neu.ms.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    // 日志记录器
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Resource
    private MsAdminMapper msAdminMapper;

    @Resource
    private UserDetailsService userDetailsService;

    //密码加密器，在SecurityConfig注入的
    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public MsAdmin getAdminByUsername(String username) {
        MsAdminExample example = new MsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<MsAdmin> msAdmins = msAdminMapper.selectByExample(example);
        if (!msAdmins.isEmpty()) {
            return msAdmins.get(0);
        }
        return null;
    }

    @Override
    public String login(AdminLoginParam adminLoginParam) {
        String token = null;
        // 这一步会进入到自己重写的UserDetailsService，在SpringSecurity中用lambda实现
        UserDetails userDetails = userDetailsService.loadUserByUsername(adminLoginParam.getUsername());
        // passwordEncoder.matches(明文,密文)
        // TODO:异常日志功能
        if (!passwordEncoder.matches(adminLoginParam.getPassword(), userDetails.getPassword())) {
            LOGGER.warn("登录异常:{}", "密码错误");
            // 运行时异常
            throw new BadCredentialsException("密码不正确");
        }
        token = jwtTokenUtils.generateToken(userDetails);
        return token;
    }

    // TODO:注册功能需要等待权限功能开发
    @Override
    public Boolean register(AdminRegisterParam adminRegisterParam) {
        MsAdminExample example = new MsAdminExample();
        return null;
    }
}
