package com.neu.ms.controller;

import com.neu.ms.common.CommonResult;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.service.AdminService;
import com.neu.ms.vo.User;
import com.neu.ms.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 这里要用@RestController(=@Controller + @ResponseBody)
// @Controller是用来响应页面的，必须配合模板引擎来使用，返回一个view(MVC中的V)
// 而@ResponseBody将所有的API接口返回的数据，都会以json格式返回给客户端
@RestController
// @CrossOrigin用于解决跨域问题，参数意义如下
// origins：允许可访问的域列表
// maxAge：准备响应前的缓存持续的最大时间（以秒为单位）
// @CrossOrigin(origins = "*", maxAge = 3600)
// 现在已经实现全局跨域，配置在config.CorsConfig下
public class LoginController {
    @Resource
    AdminService adminService;
    // 也可以用PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // post请求，参数接收需要添加注解@RequsetBody用来接收contentType为application/json的传入对象，
    // @RequestParam用来获取查询参数，形式get请求的url?name=
    // json数据会自动转换成对象，即User
    public CommonResult login(@RequestBody User user) {
        if (adminService.checkAdminPassword(user)) {
            return  CommonResult.success(null);
        } else {
            return CommonResult.validateFailed("用户名或密码错误");
        }
    }
}
