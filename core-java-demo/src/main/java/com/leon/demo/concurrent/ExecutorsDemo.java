package com.leon.demo.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.leon.demo.concurrent.task.MyRunnableTask;

public class ExecutorsDemo {
	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(80);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 30, 10, TimeUnit.SECONDS, queue);
		new Thread(new MyExecutorMonitor(executor)).start(); //启动监控
//		executor.allowCoreThreadTimeOut(true);
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			executor.submit(new MyRunnableTask(""+i));
		}
		
	}
}
/**
 * 线程池监控
 * @author leonwang
 *
 */
class MyExecutorMonitor implements Runnable{
	private ThreadPoolExecutor pool;
	public MyExecutorMonitor(ThreadPoolExecutor pool) {
		this.pool = pool;
	}
	@Override
	public void run() {
		System.out.println("pool监控启动--------");
		while (!pool.isShutdown()) {
			try {
				int undotasksize = pool.getQueue().size(); //当前队列任务数
				int threadnum = pool.getPoolSize(); //当前线程数
				long alltaskcount = pool.getTaskCount(); //所有任务数
				long donetaskcount = pool.getCompletedTaskCount(); //已完成任务数
				System.out.println("alltaskcount["+alltaskcount+"] donetaskcount["+donetaskcount+"] undotasksize["+undotasksize+"] threadnum["+threadnum+"]");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("pool has been shutted down -------");
	}
}