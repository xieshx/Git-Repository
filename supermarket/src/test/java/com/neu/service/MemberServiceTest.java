package com.neu.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberServiceTest {

    @Test
    public void queryMemberById() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemberService memberService = (MemberService) act.getBean("memberService");
        memberService.queryMemberById(1001);
    }
}