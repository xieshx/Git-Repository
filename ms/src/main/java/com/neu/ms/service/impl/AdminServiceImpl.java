package com.neu.ms.service.impl;

import com.neu.ms.mbg.mapper.MsAdminMapper;
import com.neu.ms.mbg.model.MsAdmin;
import com.neu.ms.mbg.model.MsAdminExample;
import com.neu.ms.service.AdminService;
import com.neu.ms.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    MsAdminMapper msAdminMapper;
    @Override
    public Boolean checkAdminPassword(User user) {
        MsAdminExample example=new MsAdminExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        //通过debug发现mapper查询返回的list实现类是ArrayList
        List<MsAdmin> msAdmins = msAdminMapper.selectByExample(example);
        if(!msAdmins.isEmpty()&&msAdmins.get(0).getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
