package com.neu.ms.controller;

import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.neu.ms.common.api.CommonResult;
import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.dto.AdminRegisterParam;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.service.AdminService;
import com.neu.ms.vo.AdminVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

// 这里要用@RestController(=@Controller + @ResponseBody)
// @Controller是用来响应页面的，必须配合模板引擎来使用，返回一个view(MVC中的V)
// 而@ResponseBody将所有的API接口返回的数据，都会以json格式返回给客户端
@RestController
// @CrossOrigin用于解决跨域问题，参数意义如下
// origins：允许可访问的域列表
// maxAge：准备响应前的缓存持续的最大时间（以秒为单位）
// @CrossOrigin(origins = "*", maxAge = 3600)
// 现在已经实现全局跨域，配置在config.CorsConfig下
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    // 也可以用PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // post请求，参数接收需要添加注解@RequsetBody用来接收contentType为application/json的传入对象，
    // @RequestParam用来获取查询参数，形式get请求的url?name=
    // json数据会自动转换成对象，即User
    public CommonResult login(@RequestBody AdminLoginParam adminLoginParam) {
        String token = adminService.login(adminLoginParam);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, Object> adminMap = new HashMap<>();
        adminMap.put("token", token);
        // TODO:tokenHead是什么作用？
        adminMap.put("tokenHead", tokenHead);
        // TODO:总感觉这样不好
        MsAdmin admin = adminService.getAdminByUsername(adminLoginParam.getUsername());
        AdminVo adminVo=new AdminVo();
        BeanUtils.copyProperties(admin, adminVo);
        adminMap.put("adminInfo",adminVo);
        return CommonResult.success(adminMap);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody AdminRegisterParam adminRegisterParam) {
        adminService.register(adminRegisterParam);
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list(@RequestParam(value = "pageStart", defaultValue = "1") Integer pageStart,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageInfo adminList = adminService.getAdminList(pageStart, pageSize);
        return CommonResult.success(adminList);
    }

}
