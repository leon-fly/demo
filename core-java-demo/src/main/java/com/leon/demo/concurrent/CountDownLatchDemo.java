package com.leon.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : leonwang
 * @Descpriction CountDownLatch是一个同步计数器，调用await阻塞当前线程，调用countDown计数减1，当计数为0时唤醒等待阻塞当线程
 * @Date:created 2020/2/29
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int workNum = 5;
        CountDownLatch countDownLatch = new CountDownLatch(workNum);
        for (int i=0;i<workNum;i++){
            new Thread(new Worker(countDownLatch),"NO-"+i).start();
            Thread.sleep(1000);
        }
        countDownLatch.await();
        System.out.println("woo, now I know all worker is ready");
    }
}



class Worker implements Runnable {
    private CountDownLatch readyCountDownLatch;

    public Worker(CountDownLatch readyCountDownLatch){
        this.readyCountDownLatch = readyCountDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":prepare for work start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":prepare for work finished...");
        readyCountDownLatch.countDown();
    }
}
