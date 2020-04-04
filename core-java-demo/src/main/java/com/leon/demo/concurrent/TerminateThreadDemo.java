package com.leon.demo.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/12
 */
public class TerminateThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        System.out.println("线程已启动");
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
        System.out.println("线程终止命令已发出");

    }

    static class MyRunnable implements Runnable {
        int i = 0;

        @Override
        public void run() {
            while (true) {
                System.out.println("I am running..." + i++);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("线程被终止...");
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
