package com.leon.demo.concurrent.task;

import java.util.Date;
import java.util.Random;

public class MyRunnableTask implements Runnable{
	private String taskNum;

	public MyRunnableTask(String taskNum) {
		this.taskNum = taskNum;
	}
	@Override
	public void run() {
		System.out.println(">>>" + System.currentTimeMillis()+"==="+taskNum + "任务开始");
		Date dateTmp1 = new Date();
		int sleepTime = new Random().nextInt(30)*1000;
		System.out.println(System.currentTimeMillis()+"==="+taskNum+"任务休眠时间："+sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + System.currentTimeMillis()+"==="+taskNum + "任务终止,执行时间:"+time);
	}

}
