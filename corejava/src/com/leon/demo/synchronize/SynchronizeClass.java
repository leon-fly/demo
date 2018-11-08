package com.leon.demo.synchronize;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/11/6
 */
public class SynchronizeClass {

    public synchronized static void method1(String name) throws InterruptedException {
        System.out.println(name + "睡眠[method1]...");
        Thread.currentThread().sleep(10000);
        System.out.println(name + "睡眠结束[method1]...");
    }


    public synchronized static void method2(String name) throws InterruptedException {
        System.out.println(name + "睡眠[method2]...");
        Thread.currentThread().sleep(10000);
        System.out.println(name + "睡眠结束[method2]...");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        SynchronizeClass.method1(Thread.currentThread().getId()+"");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        SynchronizeClass.method2(Thread.currentThread().getId()+"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();

    }

}
