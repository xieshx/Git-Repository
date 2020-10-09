package com.neu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @RequestMapping("/success")
    public String success(Map<String, String> map){
        map.put("key","hello");
        return "success";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
