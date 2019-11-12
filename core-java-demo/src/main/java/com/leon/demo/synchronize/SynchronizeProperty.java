package com.leon.demo.synchronize;

/**
 * @Author : leonwang
 * @Descpriction 锁定共享资源的类
 * @Date:created 2018/11/6
 */
public class SynchronizeProperty {
    private static String shareSource = "source";

    public static void shareSourceOperate1(String name) throws InterruptedException {
        synchronized (shareSource) {  //shareSource作为锁内容不能为空
            System.out.println(name + ">>调用开始[method:shareSourceOperate1]...");
            Thread.currentThread().sleep(500);
            System.out.println(name + ">>调用结束[method:shareSourceOperate1]...");
        }
    }

    public static void shareSourceOperate2(String name) throws InterruptedException {
        synchronized (shareSource) {
            System.out.println(name + ">>调用开始[method:shareSourceOperate2]...");
            Thread.currentThread().sleep(500);
            System.out.println(name + ">>调用结束[method:shareSourceOperate2]...");
        }
    }

    public static void operate(String name) throws InterruptedException {
        System.out.println(name + ">>调用开始[method:operate]...");
        Thread.currentThread().sleep(200);
        System.out.println(name + ">>调用结束[method:operate]...");
    }

    public static void main(String[] args) {
        Thread t1 = new ShareSourceOperate1Thread("竞争锁线程1");

        Thread t11 = new ShareSourceOperate1Thread("竞争锁线程11");

        Thread t2 = new ShareSourceOperate2Thread("竞争锁线程2");

        Thread t3 = new OperateThread("-----无竞争线程3");

        Thread t4 = new OperateThread("-----无竞争线程4");

        t1.start();

        t11.start();

        t2.start();

        t3.start();

        t4.start();
    }
}

class ShareSourceOperate1Thread extends Thread{

    public ShareSourceOperate1Thread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                SynchronizeProperty.shareSourceOperate1(Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ShareSourceOperate2Thread extends Thread{

    public ShareSourceOperate2Thread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                SynchronizeProperty.shareSourceOperate2(Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class OperateThread extends Thread{

    public OperateThread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                SynchronizeProperty.operate(Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
