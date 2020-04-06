package com.leon.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : leonwang
 * @Descpriction 插入排序
 * 逻辑：从第二位数开始与前面的有序位比较，找到合适的位置进行插入。每次处理一个，处理过的都是有序的。
 * 稳定性排序算法
 * 时间复杂度O(n²)
 * 空间复杂度O（1）
 * 比较：插入排序比冒泡排序在交换方便节省时间
 * @Date:created 2020/4/6
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] array = {10, 4, 9, 6, 1, 3, 5, 8};
        System.out.println(Arrays.toString(sortAsc(array)));
    }

    public static int[] sortAsc(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int changePosition = 0;
            for (int i = 0; i < index; i++) {
                if (array[index] < array[i]) {
                    changePosition = i;
                    int temp = array[index];

                    for (int j = 0; j < index - changePosition; j++) {
                        array[index - j] = array[index - j - 1];
                    }
                    array[changePosition] = temp;
                    System.out.println(String.format("第%s次排序：%s", index, Arrays.toString(array)));
                    continue;
                }
            }
        }
        return array;
    }
}
