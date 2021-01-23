package com.neu.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String index(Model model){
        model.addAttribute("name","thymeleaf");
        return "hello";
    }
}
