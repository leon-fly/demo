package com.leon.demo.collection;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String,String> hm = new HashMap<>();
		System.out.println("创建完成");
		for(int i=0;i<100;i++){
			System.out.println("第"+i+"个");
			hm.put(i+"", ""+i);
		}
	}
}
