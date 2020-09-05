package com.neu.controller;

import com.neu.exception.AgeException;
import com.neu.exception.MyUserException;
import com.neu.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MyController {

    @GetMapping("/some.do")
    public ModelAndView doGet(String username,Integer userage) throws MyUserException {

        ModelAndView modelAndView = new ModelAndView();

        if (!"zs".equals(username)) {
            throw new NameException("姓名不正确！！！");
        }

        if (userage == null || userage > 80) {
            throw new AgeException("年龄比较大！！！");
        }

        modelAndView.addObject("name",username);
        modelAndView.addObject("age",userage);
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
