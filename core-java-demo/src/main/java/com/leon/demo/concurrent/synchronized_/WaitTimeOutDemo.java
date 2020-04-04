package com.leon.demo.concurrent.synchronized_;

import java.util.concurrent.TimeUnit;

/**
 * @Author : leonwang
 * @Descpriction 等待超时模式
 * @Date:created 2020/3/10
 */
public class WaitTimeOutDemo {
    public static void main(String[] args) throws InterruptedException {
        WaitTimeOutDemo waitTimeOutDemo = new WaitTimeOutDemo();
//        waitTimeOutDemo.get(5000);

        //线程争锁公平性
//        new Thread(() -> {
//            while (true) {
//                waitTimeOutDemo.synA();
//            }
//        }).start();
//        new Thread(() -> {
//            while (true)
//                waitTimeOutDemo.synB();
//        }).start();


        //多cpu执行测试
        //线程争锁公平性
//        new Thread(() -> {
//            while (true) {
//                waitTimeOutDemo.normalMethodA();
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true)
//                waitTimeOutDemo.normalMethodB();
//        }).start();


        //线程等待超时模式测试
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    waitTimeOutDemo.get(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        new Thread(() -> {
            while (true) {
                waitTimeOutDemo.notifyMethod();
            }
        }).start();


    }


    /**
     * 等待
     *
     * @param millisecond
     * @throws InterruptedException
     */
    public synchronized void get(long millisecond) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        long deadLine = System.currentTimeMillis() + millisecond;

        long remain;

        System.out.println(Thread.currentThread().getId() + ":进入时间:" + currentTimeMillis + ", 等待截止时间：" + deadLine + "===================");
        boolean conditionGot = false; //模拟条件获取不到的情况
        while (!conditionGot && (remain = deadLine - System.currentTimeMillis()) > 0) {
            System.out.println("get条件不满足,未超时，等待...");
            wait(remain);
            System.out.println("get被唤醒...");
        }
        System.out.println(Thread.currentThread().getId() + ":退出,耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "=======================");
    }

    public synchronized void notifyMethod() {
        notifyAll();
        System.out.println("唤醒其他...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void synA() {
        System.out.println("a 在执行  》》》》》》》》》》》》》");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void synB() {
        System.out.println("b -------- 在执行  》》》》》》》》》》》》》");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void normalMethodA() {
        System.out.println("normalA 在执行  》》》》》》》》》》》》》");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalMethodB() {
        System.out.println("normalB -------- 在执行  》》》》》》》》》》》》》");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
