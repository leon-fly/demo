package com.leon.demo.service;

import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class TestUtil {
    public static int[] generate(int valueCount){
        int[] values = new int[valueCount];
        Random random = new Random();
        for (int i = 0; i < valueCount; i++) {
            int randomValue = random.nextInt(1000);
            values[i] = randomValue;
        }
        return values;
    }
}
