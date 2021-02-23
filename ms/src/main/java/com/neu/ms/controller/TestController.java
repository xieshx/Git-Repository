package com.neu.ms.controller;

import com.neu.ms.common.api.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public CommonResult Test1(){
        System.out.println("登出生成");
        return CommonResult.success(null);
    }
}
