package com.leon.demo.concurrent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 线程实现方式
 * 
 * @author leonwang
 *
 */
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// testWorkThread（）；

		// testRunnable();

		// testCallable();
		testExecutor();
	}

	/**
	 * 方式一
	 */
	static void testWorkThread() {
		WorkThread t1 = new WorkThread();
		t1.setName("A");
		t1.start();
	}

	/**
	 * 方式二
	 */
	static void testRunnable() {
		Thread t1 = new Thread(new WorkRunnable());
		t1.setName("A");
		t1.start();
	}

	/**
	 * 方式三
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	static void testCallable() throws InterruptedException, ExecutionException {

		/*
		 * FutureTask future = new FutureTask(new WorkCallable()); future.run();
		 * Object result = null; for(int i=0;i<10;i++){ result = future.get();
		 * if(result==null) Thread.sleep(1000); else{
		 * System.out.println("result="+result); }
		 * 
		 * }
		 */
	}

	/**
	 * 方式四 有返回值线程实现。
	 * callable接口实现 + Executor提交任务，并用future接收执行结果（future的get是阻塞式的）。
	 * Executor submit后完成顺序不确定
	 * 
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	static void testExecutor() throws InterruptedException, ExecutionException {
		System.out.println("----程序开始运行----");
		Date date1 = new Date();

		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务
		List<Future<String>> list = new ArrayList<Future<String>>();
		for (int i = 0; i < taskSize; i++) {
			MyCallable c = new MyCallable(i + " ");
			// 执行任务并获取Future对象
			Future<String> f = pool.submit(c);
			System.out.println(">>>threadpool submit 结束-----"+i );
			list.add(f);
			System.out.println(">>>thread返回的存储的future 添加至list----"+i );
		}
		// 关闭线程池
		pool.shutdown();
		System.out.println(">>>准备开始读取所有线程的执行结果:");
		int num=1;
		// 获取所有并发任务的运行结果
		for (Future<String> f : list) {
			System.out.println(">>>循环获取第"+num+"个");
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>第"+num+++"个future的线程执行结果值为：" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}

/**
 * 继承thread实现线程
 * 
 * @author leonwang
 *
 */
class WorkThread extends Thread {
	public WorkThread() {

	}

	@Override
	public void run() {
		for (int i = 0;; i++) {
			System.out.println("workthread:" + this.getName() + "   " + i);
		}
	}
}

/**
 * 实现runnable
 * 
 * @author leonwang
 *
 */
class WorkRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0;; i++)
			System.out.println("runnable:" + i);
	}

}

/**
 * 
 * @author leonwang
 *
 */
class WorkCallable implements Callable<String> {
	int a = 100;

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 100000; i++) {
			System.out.println("WorkCallable:" + i);
			a++;
		}

		return "" + a;
	}
}

/**
 * 
 * @author leonwang
 *
 */
class MyCallable implements Callable<String> {
	private String taskNum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	public String call() throws Exception {
		System.out.println(">>>" + taskNum + "任务开始");
		Date dateTmp1 = new Date();
		int sleepTime = new Random().nextInt(100)*1000;
		System.out.println(taskNum+"任务休眠时间："+sleepTime);
		Thread.sleep(sleepTime);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return (taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】,休眠时间："+sleepTime);
	}
}
