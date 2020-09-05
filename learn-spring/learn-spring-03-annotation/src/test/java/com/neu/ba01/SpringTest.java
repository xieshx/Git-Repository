package com.neu.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test1(){
        String config="applicationContext.xml";
        ApplicationContext ac =new  ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

}