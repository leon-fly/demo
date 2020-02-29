package com.leon.demo.concurrent;

/**
 * @Author : leonwang
 * @Descpriction 锁定静态方法的类
 * @Date:created 2018/11/6
 */
public class SynchronizeClass {

    public synchronized static void staticMethod1(String name) throws InterruptedException {
        System.out.println(name + "睡眠[staticMethod1]...");
        Thread.currentThread().sleep(100000);
        System.out.println(name + "睡眠结束[staticMethod1]...");
    }


    public synchronized static void staticMethod2(String name) throws InterruptedException {
        System.out.println(name + "睡眠[staticMethod2]...");
        Thread.currentThread().sleep(100000);
        System.out.println(name + "睡眠结束[staticMethod2]...");
    }

    public synchronized void method1(String name) throws InterruptedException {
        System.out.println(name + "睡眠[method1]...");
        Thread.currentThread().sleep(100000);
        System.out.println(name + "睡眠结束[method1]...");
    }


    public synchronized void method2(String name) throws InterruptedException {
        System.out.println(name + "睡眠[method2]...");
        Thread.currentThread().sleep(100000);
        System.out.println(name + "睡眠结束[method2]...");
    }

    /**
     * synchronized锁定方法时锁定对象是类，有锁的方法都要等待
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        SynchronizeClass.staticMethod1(Thread.currentThread().getName()+"");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        SynchronizeClass.staticMethod2(Thread.currentThread().getName()+"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        SynchronizeClass s = new SynchronizeClass();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        s.method1(Thread.currentThread().getName()+"");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3");

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        s.method1(Thread.currentThread().getName()+"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t4");

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        s.method2(Thread.currentThread().getName()+"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t5");


        SynchronizeClass s2 = new SynchronizeClass();
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        s2.method1(Thread.currentThread().getName()+"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t6");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

}
