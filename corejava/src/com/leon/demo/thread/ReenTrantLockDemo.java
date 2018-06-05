package com.leon.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockDemo {
	public int count = 0;
	public static void main(String[] args) {
		
	}
	
	public void increace(){
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		System.out.println(Thread.currentThread().getId()+"==count原值="+count);
		count++;
		System.out.println(Thread.currentThread().getId()+"==count+1后值"+count);
		lock.unlock();
	}
}
