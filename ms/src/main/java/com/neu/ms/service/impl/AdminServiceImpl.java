package com.neu.ms.service.impl;

import com.neu.ms.common.utils.JwtTokenUtil;
import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.mbg.mapper.MsAdminMapper;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.mbg.model.MsAdminExample;
import com.neu.ms.service.AdminService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private MsAdminMapper msAdminMapper;

    @Resource
    private UserDetailsService userDetailsService;

    //密码加密器，在SecurityConfig注入的
    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public MsAdmin getAdminByUsername(String username) {
        MsAdminExample example = new MsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        //通过debug发现mapper查询返回的list实现类是ArrayList
        List<MsAdmin> msAdmins = msAdminMapper.selectByExample(example);
        if (!msAdmins.isEmpty()) {
            return msAdmins.get(0);
        }
        return null;
    }

    @Override
    public String login(AdminLoginParam adminLoginParam) {
        String token = null;
        UserDetails userDetails = userDetailsService.loadUserByUsername(adminLoginParam.getUsername());
        //passwordEncoder.matches(明文,密文)
        //TODO:异常日志功能
        if (!passwordEncoder.matches(adminLoginParam.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }
}
