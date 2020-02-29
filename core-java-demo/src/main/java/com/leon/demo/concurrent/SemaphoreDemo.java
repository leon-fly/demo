package com.leon.demo.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @Author : leonwang
 * @Descpriction 假设某公司有5辆车，公司10个部门领导出差需要使用
 * @Date:created 2020/2/29
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int leaderNum = 10;
        Semaphore carSemaphore = new Semaphore(5);
        for (int i = 0; i < leaderNum; i++) {
            new Thread(new Leader(carSemaphore), "Leader-"+i).start();
        }
    }
}


class Leader implements Runnable {

    private Semaphore carSemaphore;

    public Leader(Semaphore carSemaphore) {
        this.carSemaphore = carSemaphore;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.currentThread().sleep(random.nextInt(50000));
                System.out.println(Thread.currentThread().getName() + ":come for car ------------");

                carSemaphore.acquire(1);

                System.out.println(Thread.currentThread().getName() + ":got car >>>>>>>>>>>>>>>>>>>>  remain:" + carSemaphore.availablePermits());
                Thread.sleep(random.nextInt(50000) + 1000);

                carSemaphore.release(1);
                System.out.println(Thread.currentThread().getName() + ":return car <<<<<<<<<<<<<<<<<< remain:" + carSemaphore.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}