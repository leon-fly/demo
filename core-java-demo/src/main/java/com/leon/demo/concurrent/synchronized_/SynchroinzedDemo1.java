package com.leon.demo.concurrent.synchronized_;

import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction 等待/通知的经典范式
 * @Date:created 2020/3/9
 */

public class SynchroinzedDemo1 {
    Object lock = new Object();
    int money = 0;

    public void withdraw() throws InterruptedException {
        synchronized (lock) {
            System.out.println("withdraw,拿到锁。。。");
            while (money <= 0) {
                System.out.println("withdraw,等待。。。");
                lock.notifyAll();
                lock.wait();
            }
            money -= 1;
            System.out.println("取钱1元，剩余：" + money);
        }
    }

    public void deposit() throws InterruptedException {
        Random random = new Random();
        synchronized (lock) {
            System.out.println("deposit,拿到锁。。。");
            while (money > 0) {
                System.out.println("deposit,有钱了唤醒取钱的。。。");
                lock.notifyAll();
                lock.wait();
            }
            money += random.nextInt(10);
            System.out.println("存钱，剩余：" + money);
            Thread.sleep(10000);
        }
    }

    public static void main(String[] args) {
        SynchroinzedDemo1 demo = new SynchroinzedDemo1();
        new WithDraw(demo).start();
        new Deposit(demo).start();
    }
}

class WithDraw extends Thread {
    SynchroinzedDemo1 synchroinzedDemo1;

    WithDraw(SynchroinzedDemo1 synchroinzedDemo1) {
        super();
        this.synchroinzedDemo1 = synchroinzedDemo1;

    }

    @Override
    public void run() {
        try {
            while (true)
                synchroinzedDemo1.withdraw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Deposit extends Thread {
    SynchroinzedDemo1 synchroinzedDemo1;

    Deposit(SynchroinzedDemo1 synchroinzedDemo1) {
        super();
        this.synchroinzedDemo1 = synchroinzedDemo1;

    }

    @Override
    public void run() {
        try {
            while (true)
                synchroinzedDemo1.deposit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}