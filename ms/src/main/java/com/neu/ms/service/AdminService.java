package com.neu.ms.service;

import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.dto.AdminRegisterParam;
import com.neu.ms.mbg.model.MsAdmin;

import java.util.List;

public interface AdminService {

    //通过用户名获取该账户的model
    MsAdmin getAdminByUsername(String username);

    //登录功能，成功后返回一个token
    String login(AdminLoginParam adminLoginParam);

    //获取所有用户，生成列表
    List<MsAdmin> getAdminList();

    //注册用户
    Boolean register(AdminRegisterParam adminRegisterParam);

}
