package com.leon.demo.concurrent.task;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallableTask implements Callable<String>{
	private String taskNum;

	public MyCallableTask(String taskNum) {
		this.taskNum = taskNum;
	}

	public String call() {
		System.out.println(">>>" + taskNum + "任务开始");
		Date dateTmp1 = new Date();
		int sleepTime = new Random().nextInt(100)*1000;
		System.out.println(taskNum+"任务休眠时间："+sleepTime);
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return (taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】,休眠时间："+sleepTime);
	}
}
