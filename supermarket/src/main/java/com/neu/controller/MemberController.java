package com.neu.controller;

import com.neu.pojo.Member;
import com.neu.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 会员表(Member)表控制层
 *
 * @author makejava
 * @since 2020-09-20 10:00:57
 */

@RestController
@RequestMapping("/member")
public class MemberController {

    /**
     * 服务对象
     */
    @Resource
    private MemberService memberService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Member selectOne(Integer id) {
        Member member = memberService.queryMemberById(id);
        System.out.println(member);
        return member;
    }

}