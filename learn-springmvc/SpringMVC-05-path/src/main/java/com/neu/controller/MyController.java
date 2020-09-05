package com.neu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {

    @GetMapping("/get.do")
    public ModelAndView doGet(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","欢迎");
        modelAndView.addObject("fun","doGet方法");
        modelAndView.setViewName("show");
        System.out.println("==============标记==================");
        return modelAndView;
    }

}
