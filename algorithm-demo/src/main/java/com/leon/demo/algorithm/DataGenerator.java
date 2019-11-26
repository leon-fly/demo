package com.leon.demo.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/11/22
 */
public class DataGenerator {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(DataGenerator.generatePositiveNum(100, 1000)));
    }

    /**
     * 生成不重复的数字
     *
     * @param size
     * @param maxNum
     * @return
     */
    public static int[] generatePositiveNum(int size, int maxNum) {
        Random random = new Random();
        HashSet dataSet = new HashSet();
        int[] data = new int[size];
        for (int i = 0; i < size; ) {
            int randomData = random.nextInt(1000);
            boolean success = dataSet.add(randomData);
            if (success) {
                data[i++] = randomData;
            }
        }
        return data;
    }
}
