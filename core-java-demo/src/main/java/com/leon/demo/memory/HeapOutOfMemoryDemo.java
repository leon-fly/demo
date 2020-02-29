package com.leon.demo.memory;

import java.util.ArrayList;

/**
 * @Author : leonwang
 * @Descpriction 用于演示堆溢出，运行生成dump文件，使用visual vm进行分析,找出内存占用比较大的，在分析引用该对象的类，从而找到内存泄漏处
 * 运行 vm参数 [ -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/leonwang/Desktop/ -Xms20m -Xmx100m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+PrintGCTimeStamps ]
 * @Date:created 2019/10/9
 */
public class HeapOutOfMemoryDemo {
    public  Object gcProperty;

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Nonsense nonsense = new Nonsense(list);
        HeapOutOfMemoryDemo demo = new HeapOutOfMemoryDemo();
        demo.gcProperty = nonsense;
        MemoryKiller.boom(list);
        System.out.println(demo.gcProperty);
    }
}
