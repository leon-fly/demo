package com.leon.demo.proxy.dynamic.cglib;

import com.leon.demo.service.CalculateService;
import com.leon.demo.service.TestUtil;
import com.leon.demo.service.impl.CalculateServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculateServiceImpl.class);
        enhancer.setCallback(new CPerformanceMonitorInterceptor());

        CalculateService calculateService = (CalculateService) enhancer.create();
        int[] values = TestUtil.generate(10000);
        calculateService.add(values);
    }
}
