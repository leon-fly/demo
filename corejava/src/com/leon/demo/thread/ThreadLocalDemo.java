package com.leon.demo.thread;

import java.util.Random;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal<Integer> threadlocal = new ThreadLocal<>();
		for (int i = 0; i < 2; i++) {
			Thread countThread = new CountThread(threadlocal, "线程"+i);
			countThread.start();
		}
	}
}

class CountThread extends Thread {
	ThreadLocal<Integer> threadlocal;  //声明一个线程本地变量，每个线程都有这个变量的一个副本

	public CountThread() {
	}

	public CountThread(ThreadLocal<Integer> threadlocal, String name) {
		this.threadlocal = threadlocal;
		super.setName(name);
	}

	@Override
	public void run() {
		String name = super.getName();
		System.out.println("[" + name + "]启动---------");
		threadlocal.set(1);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println("[" + name + "] value " + threadlocal.get());
			int randomvalue = random.nextInt(10);
			threadlocal.set(threadlocal.get() + randomvalue);
			System.out.println("[" + name + "] value 增加 " + randomvalue);
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		super.run();
	}

}