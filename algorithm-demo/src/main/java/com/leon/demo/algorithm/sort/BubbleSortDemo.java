package com.leon.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @Author : leonwang
 * @Descpriction冒泡排序 逻辑：两两比较，满足条件交换，每一趟都会有一个最大/最小的被移动到另一端。
 * 稳定排序算法
 * 时间复杂度O(n²)
 * 空间复杂度O（1）
 * @Date:created 2020/4/6
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = {10, 4, 9, 6, 1, 3, 5, 8};
        System.out.println(Arrays.toString(sortAsc(array)));
    }

    public static int[] sortAsc(int[] array) {
        for (int max = array.length; max > 0; max--) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < max - 1; j++) {
                if (array[j] > array[j + 1]) { //交换
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true; // 表示有数据交换
                }
            }
            System.out.println(String.format("第%s次排序：%s", array.length - max + 1, Arrays.toString(array)));
            if (!flag) {
                System.out.println("已全部有序，不再冒泡");
                break; // 没有数据交换，提前退出
            }
        }
        return array;
    }
}
