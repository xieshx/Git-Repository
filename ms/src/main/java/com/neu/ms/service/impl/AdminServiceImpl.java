package com.neu.ms.service.impl;

import com.neu.ms.dto.AdminLoginParam;
import com.neu.ms.mbg.mapper.MsAdminMapper;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.mbg.model.MsAdminExample;
import com.neu.ms.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    MsAdminMapper msAdminMapper;
    @Override
    public Boolean checkAdminPassword(AdminLoginParam adminLoginParam) {
        MsAdminExample example=new MsAdminExample();
        example.createCriteria().andUsernameEqualTo(adminLoginParam.getUsername());
        //通过debug发现mapper查询返回的list实现类是ArrayList
        List<MsAdmin> msAdmins = msAdminMapper.selectByExample(example);
        if(!msAdmins.isEmpty()&&msAdmins.get(0).getPassword().equals(adminLoginParam.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public MsAdmin getAdminByUsername(String username) {
        MsAdminExample example=new MsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<MsAdmin> msAdmins = msAdminMapper.selectByExample(example);
        if(!msAdmins.isEmpty()){
            return msAdmins.get(0);
        }
        return null;
    }
}
