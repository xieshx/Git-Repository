package com.neu.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberMapperTest {

    @Test
    public void selectByPrimaryKey() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        MemberMapper memberMapper = (MemberMapper) act.getBean("memberMapper");
        memberMapper.selectByPrimaryKey(1001);
    }
}