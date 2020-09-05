package com.neu.controller;

import com.neu.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {

    @GetMapping("/receiveGet.do")
    public ModelAndView doGet(@RequestParam("username") String name,@RequestParam("userage") int age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        modelAndView.setViewName("show");
        System.out.println("==============标记==================");
        return modelAndView;
    }

    @PostMapping("/receivePost.do")
    public ModelAndView doPost(@RequestParam("username") String name,@RequestParam("userage") int age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.addObject("age",age);
        modelAndView.setViewName("show");
        System.out.println("==============标记==================");
        return modelAndView;
    }

    @GetMapping("/receiveObject.do")
    public ModelAndView receiveObject(Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",student.getName());
        modelAndView.addObject("age",student.getAge());
        modelAndView.setViewName("show");
        System.out.println("==============标记==================");
        return modelAndView;
    }

}
