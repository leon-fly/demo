package com.leon.demo.memory;

import java.util.ArrayList;

/**
 * 用于展示gc收回过程
 * vm 参数最小内存20m 最大内存100m   [ -Xms10m -Xmx200m  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps ]
 */
public class GCDemo {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            if (i % 30 == 0) {
                arrayList.clear();
                System.out.println("清空集合");
            }
            arrayList.add(new int[1024 * 1024]);
            System.out.println("已分配：" + ((i%30)+1) + "M");
        }
        long end = System.currentTimeMillis();
        System.out.println("处理耗时：" + (end-start));  //可以调整最大堆内存查看对gc耗时情况
    }
}