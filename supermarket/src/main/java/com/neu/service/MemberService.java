package com.neu.service;

import com.neu.pojo.Member;

/**
 * 会员表(Member)表服务接口
 *
 * @author makejava
 * @since 2020-09-19 21:45:05
 */
public interface MemberService {

    Member queryMemberById(Integer id);

}