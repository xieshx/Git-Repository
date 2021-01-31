package com.neu.ms.service;

import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.vo.User;

import java.util.List;

public interface AdminService {
    Boolean checkAdminPassword(User user);
}
