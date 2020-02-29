package com.leon.demo.concurrent;

public class MemVisiableTest {
	public static void main(String[] args) throws InterruptedException {
//		testUnsafeThread();
		testSafeThread();
	}
	
	@SuppressWarnings("static-access")
	static void testUnsafeThread() throws InterruptedException{
		long nowsatrt = System.currentTimeMillis();
		MyUnsafeThread myth = new MyUnsafeThread();
		Thread t1 = new Thread(myth, "T1");
		Thread t2 = new Thread(myth, "T2");
		t1.start();
		t2.start();
		Thread.currentThread().sleep(10000);
		System.out.println(myth.num);
		long nowend = System.currentTimeMillis();
		System.out.println("不安全线程耗时："+(nowend-nowsatrt));
	}
	@SuppressWarnings("static-access")
	static void testSafeThread() throws InterruptedException{
		long nowsatrt = System.currentTimeMillis();
		MySafeThread myth = new MySafeThread();
		Thread t1 = new Thread(myth, "T1");
		Thread t2 = new Thread(myth, "T2");
		t1.start();
		t2.start();
		Thread.currentThread().sleep(10000);
		System.out.println(myth.num);
		long nowend = System.currentTimeMillis();
		System.out.println("安全线程耗时："+(nowend-nowsatrt));
	}
}


/**
 * 
 * @author leonwang
 * 非安全，内存不可见问题
 *
 */
class MyUnsafeThread implements Runnable {
	int num = 0;

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("T1")) {
			increment();
		} else {
			decrement();
		}
	}

	public void increment() {
		for (int i = 0; i < 100000; i++) {
			num++;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}

	public void decrement() {
		for (int i = 0; i < 100000; i++) {
			num--;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}
}



class MySafeThread implements Runnable {
	int num = 0;

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("T1")) {
			increment();
		} else {
			decrement();
		}
	}

	public synchronized void increment() {
		for (int i = 0; i < 100000; i++) {
			num++;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}

	public synchronized void decrement() {
		for (int i = 0; i < 100000; i++) {
			num--;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}
}


class MySafeThread2 extends Thread{
	static int num = 0;

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("T1")) {
			increment();
		} else {
			decrement();
		}
	}

	public synchronized void increment() {
		for (int i = 0; i < 100000; i++) {
			num++;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}

	public synchronized void decrement() {
		for (int i = 0; i < 100000; i++) {
			num--;
			System.out.println(Thread.currentThread().getName()+"->"+num);
		}
	}
}