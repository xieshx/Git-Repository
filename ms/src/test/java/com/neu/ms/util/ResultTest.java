package com.neu.ms.util;

import com.neu.ms.vo.Result;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void setCode() {
        Result rs =new Result(200);
        rs.setCode(25);
        System.out.println(rs.getCode());
    }

    @Test
    void getCode() {

    }
}