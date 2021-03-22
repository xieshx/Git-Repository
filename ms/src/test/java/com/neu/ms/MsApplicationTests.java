package com.neu.ms;

import com.neu.ms.common.utils.JwtTokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class MsApplicationTests {

    @Resource
    JwtTokenUtils jwtTokenUtils;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
        // String token = jwtTokenUtil.generateToken();
        // jwtTokenUtil.getUserNameFromToken(token);

    }

    @Test
    public void setPasswordEncoder(){
        String s = passwordEncoder.encode("123");
    }



}
