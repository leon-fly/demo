package com.leon.demo.concurrent;

import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction join方法测试 多线程计算n组数之和.调用了线程join方法
 * @Date:created 2019/10/6
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        int[] data1 = generate(100);
        int[] data2 = generate(50);
        int[] data3 = generate(10);

        DataBox dataBox1 = new DataBox(data1);
        DataBox dataBox2 = new DataBox(data2);
        DataBox dataBox3 = new DataBox(data3);

        Thread thread1 = new Thread(new CountThread(dataBox1));
        Thread thread2 = new Thread(new CountThread(dataBox2));
        Thread thread3 = new Thread(new CountThread(dataBox3));

        thread1.start();
        System.out.println("启动thread1");
        thread2.start();
        System.out.println("启动thread2");
        thread3.start();
        System.out.println("启动thread3");

        System.out.println("三个子线程启动结束，等待执行结束");

        System.out.println("thread1 join...");
        thread1.join();
        System.out.println("thread2 join...");
        thread2.join();
        System.out.println("thread3 join...");
        thread3.join();
        System.out.println("三个子线程执行结束");
        System.out.println("三组数据和为：" + (dataBox1.getSum() + dataBox2.getSum() + dataBox3.getSum()));


    }

    public static int[] generate(int size) {
        Random random = new Random();
        int[] generated = new int[size];
        for (int i = 0; i < size; i++) {
            generated[i] = random.nextInt(10);
        }
        return generated;
    }
}


class CountThread implements Runnable {
    private DataBox dataBox;

    CountThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i : dataBox.getData()) {
            try {
                Thread.currentThread().sleep(100); //为了看到执行过程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataBox.setSum(dataBox.getSum() + i);
        }
        System.out.println(Thread.currentThread().getName() + ":数据计算结果：" + dataBox.getSum());
    }
}

class DataBox {
    private int[] data;
    private int sum;

    DataBox(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

