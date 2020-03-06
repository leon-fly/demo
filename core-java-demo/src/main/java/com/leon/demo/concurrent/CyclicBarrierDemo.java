package com.leon.demo.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author : leonwang
 * @Descpriction 循环栅栏
 * @Date:created 2020/3/4
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("barrier冲破--------------");
            }
        });

        for (int i = 0; i < threadNum; i++) {
            MyThread thread = new MyThread(cyclicBarrier);
            thread.start();
        }


        /*for (int i=0; i<threadNum; i++){
            if (i%2==0){
                MyThread thread = new MyThread(cyclicBarrier);
                thread.start();
            }else {
                MyThread2 thread2 = new MyThread2(cyclicBarrier);
                thread2.start();
            }
        }*/
    }

}

class MyThread extends Thread {
    private CyclicBarrier cyclicBarrier;

    MyThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            System.out.println(Thread.currentThread().getId() + ":step A start...");
            Thread.currentThread().sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread().getId() + ":step A finished");

            cyclicBarrier.await();
            //多运行多次将出现不一样的结果，因为栅栏设置了超时。
//            cyclicBarrier.await(3,TimeUnit.SECONDS);

            System.out.println(Thread.currentThread().getId() + ":step B start...");
            Thread.currentThread().sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread().getId() + ":step B finished");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private CyclicBarrier cyclicBarrier;

    MyThread2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            System.out.println(Thread.currentThread().getId() + ":step AA start...");
            Thread.currentThread().sleep(random.nextInt(5000));
            System.out.println(Thread.currentThread().getId() + ":step AA finished");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}