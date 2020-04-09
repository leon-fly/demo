package com.leon.demo.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/10
 */
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.leon.demo.service.impl.*.*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("before ...");
    }

    @After(value = "pointCut()")
    public void after(){
        System.out.println("after ...");
    }

//    @Around(value = "pointCut()")
//    public void around(){
//        System.out.println("around ...");
//    }

    public void afterThrowException(){

    }

    public void afterReturning(){

    }

}
