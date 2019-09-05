package com.leon;

public class StackOverflowDemo {
	public static void main(String[] args) {
		System.out.println("test");
		test();
	}
	
	public static void test(){
		test();
	}
}

