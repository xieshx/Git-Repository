package com.neu.ba01.impl;

import com.neu.ba01.SomeService;

public class SomeServiceImpl implements SomeService {

    @Override
    public void doSomeBefore(String name, Integer age) {
        System.out.println("======目标方法doSomeBefore======");
    }

    @Override
    public String doSomeAfterReturning(String name, Integer age) {
        System.out.println("======目标方法doSomeAfterReturning======");
        return name+age;
    }

    @Override
    public String doSomeAround(String name, Integer age) {
        System.out.println("======目标方法doSomeAround======");
        return name+age;
    }
}
