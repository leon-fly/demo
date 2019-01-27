package com.leon.demo.proxy.static_;

import com.leon.demo.service.CalculateService;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class CalculateServiceProxy {
    private CalculateService calculateService;

    public CalculateServiceProxy(CalculateService calculateService){
        this.calculateService = calculateService;
    }

    public int add(int...values){
        System.out.println(String.format("性能监控开始,class:%s", calculateService.getClass().getName()));

        long start = System.currentTimeMillis();
        int sum = calculateService.add(values);
        long end = System.currentTimeMillis();

        System.out.println(String.format("性能监控结束,耗时：%d ms, class:%s", end - start, calculateService.getClass().getName()));

        System.out.println("执行结果：" + sum);

        return sum;
    }
}
