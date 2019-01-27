package com.leon.demo.proxy.dynamic.java;

import com.leon.demo.service.CalculateService;
import com.leon.demo.service.TestUtil;
import com.leon.demo.service.impl.CalculateServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class JavaProxyDemo {
    public static void main(String[] args) {
        CalculateService calculateService = (CalculateService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{CalculateService.class}, new JPerformanceMonitorInvocationHandler(new CalculateServiceImpl()));

        int[] values = TestUtil.generate(10000);

        calculateService.add(values);
    }
}
