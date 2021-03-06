package com.leon.demo.concurrent;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.leon.demo.concurrent.task.MyCallableTask;

/**
 * 有返回值的线程池结果获取优化（执行完成一个获取一个，而非按提交执行的顺序等待获取），对比ThreadDemo的testExecutor
 * @author leonwang
 *
 */
public class CompletionServiceDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("----CompletionServiceDemo程序开始运行----");
		Date date1 = new Date();

		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);	
		// 创建多个有返回值的任务
		BlockingQueue<Future<String>> queue = new ArrayBlockingQueue<Future<String>>(taskSize) ;
		ExecutorCompletionService<String> ecs = new ExecutorCompletionService<String>(pool,queue);
		for (int i = 0; i < taskSize; i++) {
			Callable<String> c = new MyCallableTask(i + " ");
			// 执行任务并获取Future对象
			ecs.submit(c);
			System.out.println(">>>threadpool submit 结束-----"+i );
		}
		// 关闭线程池
		pool.shutdown();
		System.out.println(">>>准备开始读取所有线程的执行结果:");
		int num=1;
		// 获取所有并发任务的运行结果
		for (int i=0;i<taskSize;i++) {
//			System.out.println(">>>循环获取第"+num+"个");
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>第"+num+++"个future的线程执行结果值为：" + ecs.take().get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}	


