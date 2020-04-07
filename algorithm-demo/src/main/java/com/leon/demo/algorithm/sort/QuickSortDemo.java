package com.leon.demo.algorithm.sort;

import com.leon.demo.algorithm.DataGenerator;

import java.util.Arrays;

/**
 * @Author : leonwang
 * @Descpriction 快速排序
 * 逻辑：分治思想。
 * 1. 从一组数据选择一个数据作为基准，将数据分开左右两边，以便比基准大，以便比基准小
 * 2. 将分开的两组数据递归继续划分，知道不能再划分
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度
 * @Date:created 2020/4/6
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] array = DataGenerator.generatePositiveNum(20, 100);
        sortAsc(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortAsc(int[] array){
        System.out.println("原始数据："+Arrays.toString(array));
        sortAsc(array, 0, array.length-1);
    }

    private static void sortAsc(int[] array, int startIndex, int endIndex){
        if (startIndex>=endIndex){ //满足条件终止递归
            return;
        }

        int partitionPointIndex = partitionMemSave(array, startIndex, endIndex);

        //对分区排序
        sortAsc(array, startIndex, partitionPointIndex-1);
        sortAsc(array, partitionPointIndex+1, endIndex);
    }


    /**
     * 数据分区（原地排序）
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[] array, int startIndex, int endIndex){
        //TODO
        return 0;
    }

    /**
     * 把数据分区，小于基准的放到左边，大于基准的放到右边(节省看空间，需要最大两倍的排序数据大小)
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionMemSave(int[] array, int startIndex, int endIndex){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>分区："+startIndex+","+endIndex);
        int partitionPointIndex =(endIndex+startIndex)/2;  //注意容易写错
        int partitionPointValue = array[partitionPointIndex];
        System.out.println(String.format("partitionPointIndex:%d, partitionPointValue: %d",partitionPointIndex, partitionPointValue));

        int size = endIndex-startIndex+1;
        int[] temp = new int[size];
        int leftIndex = 0;
        int rightIndex = size-1;
        for (int i=0;i<size;i++) { //循环处理整个分片各个数据
            int currentIndex = startIndex + i; //当前处理的数据行位置
            if (array[currentIndex] < partitionPointValue) {
                temp[leftIndex++] = array[currentIndex];
                continue;
            } else if (array[currentIndex] > partitionPointValue){
                temp[rightIndex--] = array[currentIndex];
            }
        }

        temp[leftIndex] = partitionPointValue;

        for (int i=0;i<size;i++){
            array[startIndex+i] = temp[i];
        }
        partitionPointIndex = startIndex+leftIndex;

        System.out.println("<<<<<<<<<<<<<<<<<<分区结果："+ Arrays.toString(array)+"\n");
        return partitionPointIndex;
    }


    /**
     * 把数据分区，小于基准的放到一个临时数组，大于基准的放一个临时数组，最后分别复制到原数组（需要总共最大三倍的排序数据空间）
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition3(int[] array, int startIndex, int endIndex){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>分区："+startIndex+","+endIndex);
        int partitionPointIndex =(endIndex+startIndex)/2; //注意容易写错
        int partitionPointValue = array[partitionPointIndex];
        System.out.println(String.format("partitionPointIndex:%d, partitionPointValue: %d",partitionPointIndex, partitionPointValue));

        int size = endIndex-startIndex+1;
        int[] little = new int[size];
        int littleIndex = 0;
        int[] bigger = new int[size];
        int biggerIndex = 0;
        for (int i=0;i<size;i++) { //循环处理整个分片各个数据
            int currentIndex = startIndex + i; //当前处理的数据行位置
            if (array[currentIndex] < partitionPointValue) {
                little[littleIndex++] = array[currentIndex];
                continue;
            } else if (array[currentIndex] > partitionPointValue){
                bigger[biggerIndex++] = array[currentIndex];
            }
        }

        int currentIndex = startIndex;
        for (int i=0;i<littleIndex;i++){
            array[currentIndex++] = little[i];
        }
        partitionPointIndex = currentIndex;
        array[currentIndex++] = partitionPointValue;
        for (int i = 0;i<biggerIndex;i++){
            array[currentIndex++] = bigger[i];
        }

        System.out.println("<<<<<<<<<<<<<<<<<<分区结果："+ Arrays.toString(array)+"\n");
        return partitionPointIndex;
    }
}
