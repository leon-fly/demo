package com.leon.demo.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class SimpleDemo {
	public static void main(String[] args) {
//		ArrayList<Object> list = new ArrayList<Object>();   //数组实现
		LinkedList<Object> list = new LinkedList<>();
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(null);
//		LinkedList<Object> alist;  //双向链表实现
//		Vector<Object> vector;  //数组实现，同步
		
		
		HashSet<Object> hs = new HashSet<>();
		hs.add(1);
		hs.add(3);
		hs.add(2);
		hs.add(5);
		hs.add("hello");
		hs.add("hello");
		hs.add(null);
		TreeSet<Object> ts = new TreeSet<Object>();
		ts.add(1);
		ts.add(3);
		ts.add(2);
		ts.add(5);
//		ts.add("hello");  不能装载不同的数据类型
		LinkedHashSet<Object> lhs = new LinkedHashSet<>();
		lhs.add(1);
		lhs.add(3);
		lhs.add(2);
		lhs.add(5);
		lhs.add("hello");
		
		System.out.println("list==");
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println("treeset=========");
		for (Object object : ts) {
			System.out.println(object);
		}
		System.out.println("hashset=========");
		for (Object object : hs) {
			System.out.println(object);
		}
		System.out.println("linkedhashset=========");
		for (Object object : lhs) {
			System.out.println(object);
		}
		
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put(null, null);
		System.out.println("hashmap==========");
		System.out.println(hashmap.get(null));
		
		HashMap<String, String> treemap = new HashMap<>();
		treemap.put(null, null);
		System.out.println("treemap==========");
		System.out.println(treemap.get(null));
		
//		Hashtable<?, ?> ht;
		
//		Hashtable<String, String> hta = new Hashtable<>();  
//		hta.put(null, null);  //不允许空值
//		System.out.println("hashtable==========");
//		System.out.println(hta.get(null));
	}
}
