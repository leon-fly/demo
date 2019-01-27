package com.leon.demo.proxy.dynamic.java;

import com.leon.demo.service.CalculateService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class JPerformanceMonitorInvocationHandler implements InvocationHandler {

    private CalculateService calculateService;

    public JPerformanceMonitorInvocationHandler(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("性能监控开始,class:%s, method：%s", calculateService.getClass().getName(), method.getName()));
        long start = System.currentTimeMillis();

        Object object = method.invoke(calculateService, args);

        long end = System.currentTimeMillis();
        System.out.println(String.format("性能监控结束,耗时：%d ms, class:%s, method：%s", end - start, proxy.getClass().getName(), method.getName()));
        System.out.println("执行结果：" + object);
        return object;
    }

}
