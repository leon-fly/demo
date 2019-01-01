package com.leon.demo.collection;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
//		int ind = 0;
		int ssize = s.size();
		for(int a=0;a<ssize;a++){
			System.out.println("第"+a +"个数据是"+s.pop());
		}
		
	}
}
