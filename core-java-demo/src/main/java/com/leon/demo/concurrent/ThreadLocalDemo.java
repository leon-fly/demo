package com.leon.demo.concurrent;

import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction 示例展示了各个线程设置和获取自己的线程变量，互不干涉。从执行结果可以看出
 * @Date:created 2020/2/29
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    public void setThreadLocalValue(int value) {
        threadLocal.set(value);
        System.out.println(Thread.currentThread().getName() + ":设置线程变量值为：" + value);
    }

    public Integer getThreadLocalValue() {
        Integer value = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ":获取线程变量值为：" + value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalDemo td = new ThreadLocalDemo();
        int threadNum = 30;
        for (int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                Random random = new Random();
                @Override
                public void run() {
                    td.setThreadLocalValue(random.nextInt(100000));
                    try {
                        //避免线程一口气执行完，让它停一会儿让其他线程执行
                        Thread.currentThread().sleep(random.nextInt(5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    td.getThreadLocalValue();
                }
            }, "Thread-" + i).start();
        }
    }

}