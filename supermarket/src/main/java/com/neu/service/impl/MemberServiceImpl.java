package com.neu.service.impl;

import com.neu.dao.MemberMapper;
import com.neu.pojo.Member;
import com.neu.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 会员表(Member)表服务实现类
 *
 * @author makejava
 * @since 2020-09-19 21:50:16
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper mapper;

    @Override
    public Member queryMemberById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
    
}