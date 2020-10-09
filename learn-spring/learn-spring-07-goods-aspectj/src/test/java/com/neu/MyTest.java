package com.neu;

import com.neu.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        String config="applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        BuyGoodsService buyService = (BuyGoodsService) ac.getBean("buyService");

        buyService.buy(1001,10);


    }

}
