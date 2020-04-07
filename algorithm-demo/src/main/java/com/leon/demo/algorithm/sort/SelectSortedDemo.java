package com.leon.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : leonwang
 * @Descpriction 选择排序
 * 逻辑：每一趟找出一个当前未排序的最小值放在已排序的末尾（交换）
 * 非稳定性排序（存在交换过程，交换之后可能使原来顺序变动）
 * 时间复杂度O(n²)
 * 空间复杂度O（1）
 * @Date:created 2020/4/6
 */
public class SelectSortedDemo {
    public static void main(String[] args) {
        int[] array = {10, 4, 9, 6, 1, 3, 5, 8};
        sortAsc(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sortAsc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            //交换
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

            System.out.println(String.format("第%s次排序：%s", i, Arrays.toString(array)));
        }
        return array;
    }
}
