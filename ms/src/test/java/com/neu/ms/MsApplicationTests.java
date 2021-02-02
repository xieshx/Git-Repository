package com.neu.ms;

import com.neu.ms.common.utils.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MsApplicationTests {

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Test
    void contextLoads() {
        String token = jwtTokenUtil.generateToken();
    }

}
