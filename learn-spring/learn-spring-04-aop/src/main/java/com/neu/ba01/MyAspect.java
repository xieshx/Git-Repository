package com.neu.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;


@Aspect
public class MyAspect {

    // 前置通知
    @Before("execution(* com.neu.ba01.impl.SomeServiceImpl.doSomeBefore(..))")
    public void myBefore(JoinPoint jp){
        System.out.println("方法的定义："+jp.getSignature());
        System.out.println("方法的名称："+jp.getSignature().getName());
        Object[] args = jp.getArgs();
        for (Object obj:args){
            System.out.println("参数:"+obj);
        }
        System.out.println("前置通知，切面功能：在方法之前输出执行时间："+new Date());
    }

    // 后置通知
    @AfterReturning(value = "execution(* com.neu.ba01.impl.SomeServiceImpl.doSomeAfterReturning(..))",
            returning = "res")
    public void myAfterReturning(JoinPoint jp,Object res){

        System.out.println("方法的定义："+jp.getSignature());

        System.out.println("方法的名称："+jp.getSignature().getName());

        Object[] args = jp.getArgs();
        for (Object obj:args){
            System.out.println("参数:"+obj);
        }

        System.out.println("后置通知，切面功能：在方法之后输出执行时间："+new Date());

        System.out.println("后置通知：在目标方法之后执行的，获取的返回值是：" +res);
    }

    // 环绕通知
    @Around("execution(* com.neu.ba01.impl.SomeServiceImpl.doSomeAround(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("切面功能：在方法前输出执行时间："+new Date());

        // 执行目标方法
        Object resul = pjp.proceed();

        System.out.println("切面功能：在方法后输出执行时间："+new Date());

        return resul;

    }

}
