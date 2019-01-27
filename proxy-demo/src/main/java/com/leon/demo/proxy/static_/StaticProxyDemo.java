package com.leon.demo.proxy.static_;

import com.leon.demo.service.TestUtil;
import com.leon.demo.service.impl.CalculateServiceImpl;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        CalculateServiceProxy proxy = new CalculateServiceProxy(new CalculateServiceImpl());
        int[] values = TestUtil.generate(10000);
        proxy.add(values);
    }

}
