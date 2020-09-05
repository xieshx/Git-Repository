package com.neu;

import com.neu.service.ServiceDemo1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    /**
     * 入门案例
     */
    @Test
    public void test1() {
        // spring容器创建对象
        // 指定spring配置文件
        String config = "spring-config.xml";
        // 创建Spring容器对象，ApplicationContext，通过这个容器获取对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象，调用方法，参数是配置文件中bean的id值
        ServiceDemo1 serviceDemo1 = (ServiceDemo1) applicationContext.getBean("serviceDemo1");
        //调用对象方法
        serviceDemo1.dosome();
    }

    /**
     * 获取容器中对象的信息
     */
    @Test
    public void test2() {
        String config = "spring-config.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        //获取容器中定义对象的数量
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println(count);
        // 获取容器中定义的每个对象的名称
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
