package com.neu.ms.service;

import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.mbg.model.MsAdmin;

public interface AdminService {
    Boolean checkAdminPassword(AdminLoginParam adminLoginParam);
    //通过用户名获取该账户的model
    MsAdmin getAdminByUsername(String username);
}
