package com.leon.demo.service.impl;

import com.leon.demo.service.CalculateService;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class CalculateServiceImpl implements CalculateService {

    @Override
    public int add(int...values){
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
