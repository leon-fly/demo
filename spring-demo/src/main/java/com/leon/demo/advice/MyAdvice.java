package com.leon.demo.advice;

import com.leon.demo.service.ServiceImplNone;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/10
 */
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.leon.demo.service.*.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("MyAdvice before ...");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("MyAdvice after ...");
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        Long start = System.currentTimeMillis();
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("MyAdvice around: 方法运行时间为： " + (end - start));
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowException(Exception exception) {
        System.out.println("MyAdvice afterThrowException ： 有异常抛出,异常信息：" + exception.getMessage());
    }

    @AfterReturning(value = "pointCut()", returning = "rtnVal")
    public void afterReturning(ServiceImplNone.MyBean rtnVal) {
        System.out.println("MyAdvice AfterReturning 返回值：" + rtnVal.getPro());
    }

}
