package com.leon.demo.io;

import java.io.Closeable;
import java.io.IOException;
/**
 * jdk1.7之后Closeable继承了autoCloseable
 * @author leonwang
 *
 */
public class AutoCloseableDemo implements Closeable{
	public static void main(String[] args) {
		try(AutoCloseableDemo acd = new AutoCloseableDemo()){
			acd.doSomething(false);
			acd.doSomething(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("Resource autoclose --");
	}
	
	/**
	 * @param throwE 是否抛出异常，用于测试close方法是否总被调用
	 * @throws Exception
	 */
	public void doSomething(boolean throwE) throws Exception{
		System.out.println("Resource is doing something -- ");
		if (throwE) {
			throw new Exception("Exception");
		}
	}
}
