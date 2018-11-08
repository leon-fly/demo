package com.leon.demo.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * lambda表达式
 * @author leonwang
 *
 */
public class LambdaDemo {
	public static void main(String[] args) {
		//集合操作，遍历
		ArrayList<String> list = new ArrayList<String>();
		list.add("leon");
		list.add("wang");
		StringBuffer sb = new StringBuffer("hi");
		list.forEach((String x) -> sb.append("-").append(x));
		System.out.println(sb);
		
		//
		Consumer<String> consumer = (String x) -> System.out.print(x);
		list.forEach(consumer);
	}
	
	
}
