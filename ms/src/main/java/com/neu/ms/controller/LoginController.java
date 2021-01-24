package com.neu.ms.controller;

import com.neu.ms.dto.User;
import com.neu.ms.dto.Result;
import org.springframework.web.bind.annotation.*;

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
    // 也可以用PostMapping("/login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    // post请求，参数接收需要添加注解@RequsetBody用来接收contentType为application/json的传入对象，
    // json数据会自动转换成对象，即User
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username.equals("admin") && password.equals("123")) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}
