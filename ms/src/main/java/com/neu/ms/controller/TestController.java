package com.neu.ms.controller;

import com.neu.ms.mbg.mapper.MsAdminMapper;
import com.neu.ms.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private MsAdminMapper msAdminMapper;
    @Resource
    private AdminService adminService;

    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("name", "thymeleaf");
        msAdminMapper.selectByPrimaryKey(1);
        adminService.getAdminByUsername("admin");
        return "hello";
    }
}