package com.leon.demo.thread.synchronized_;
/**
 * synchronized作用在方法上之后,锁定的是一个类。只能同时进入一个synchronized方法，其他非synchronized方法不影响。
 * @author leonwang
 *
 */
public class SynchronizedMethodDemo {
	public static void main(String[] args) {
		Counter counter = new Counter();
		new IncreaseThread(counter).start();
		new MinusThread(counter).start();
		counter.nonsynmethod();
	}
}
class IncreaseThread extends Thread{
	private Counter counter;  
	public IncreaseThread(Counter counter) {
		this.counter = counter;
		System.out.println("IncreaseThread created");
	}
	@Override
	public void run() {
		System.out.println("IncreaseThread run---------");
		for (int i = 0; i < 10; i++) {
			try {
				counter.increace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
}

class MinusThread extends Thread{
	private Counter counter;  
	public MinusThread(Counter counter) {
		this.counter = counter;
		System.out.println("MinusThread created");
	}
	@Override
	public void run() {
		System.out.println("MinusThread run---------");
		for (int i = 0; i < 20; i++) {
			try {
				counter.minus();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.run();
	}
}

class Counter{
	private int num = 0;
	public synchronized void increace() throws InterruptedException{
		System.out.println("increase===原始值："+num);
		Thread.sleep(5000);
		num+=1;
		System.out.println("增加后的num值："+num);
	}
	public synchronized void minus() throws InterruptedException{
		System.out.println("minus===原始值："+num);
		Thread.sleep(5000);
		num-=1;
		System.out.println("减后的num值："+num);
	}
	public void nonsynmethod(){
		System.out.println("非同步方法被调用");
	}
}