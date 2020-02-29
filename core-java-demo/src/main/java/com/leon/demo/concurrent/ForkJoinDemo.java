package com.leon.demo.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoin框架 jdk1.7以上
 * 整体思想：将一个大的任务拆分（fork）成若干个小任务,最终将小任务结果合并。
 * @author leonwang
 *
 */
public class ForkJoinDemo {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(3);
		// 生成一个计算任务，负责计算1+2+3+4
		TestForkJoin task = new TestForkJoin(1, 20000);
		// 执行一个任务
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
	}
}

/**
 * 常使用的两个类RecursiveAction（无返回值） & RecursiveTask（有返回值）
 * @author leonwang
 *
 */
class TestForkJoin extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 5;// 阈值
	private int start;
	private int end;
	public TestForkJoin(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 如果任务足够小就计算任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
			System.out.println("线程："+Thread.currentThread().getName());
		} else {
			// 如果任务大于阀值，就分裂成两个子任务计算
			int middle = (start + end) / 2;
			TestForkJoin leftTask = new TestForkJoin(start, middle);
			TestForkJoin rightTask = new TestForkJoin(middle + 1, end);

			// 执行子任务
			leftTask.fork();
			rightTask.fork();

			// 等待子任务执行完，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();

			// 合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}
}

