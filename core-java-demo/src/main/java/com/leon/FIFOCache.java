package com.leon;

import java.util.HashMap;
import java.util.LinkedList;

class FIFOCache<T> {
	private int capacity;
	private int size;
	private LinkedList<String> keys;
	private HashMap<String,T> container;
	public FIFOCache(int capacity) {
		this.capacity=capacity;
		keys = new LinkedList<>();
		container = new HashMap<>(capacity);
		size = 0;
	}
	public void put(String key, T value){
		if(container.containsKey(key)){
			container.put(key, value);
			return;
		}
		if(size>=capacity){
			String rmdkey = keys.remove(0);  //移除第一个元素
			container.remove(rmdkey);
		}else{
			size++;
		}
		keys.add(key);
		container.put(key, value);
	}
	
	public T get(String key){
		return container.get(key);
	}
	
	public int size(){
		return container.size();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		FIFOCache<String> c = new FIFOCache<>(100000);
		for(int i=0;i<100000;i++){
			System.out.println("begin==="+i);
			c.put(""+i, ""+i);
		}
		/*c.put("a", "1");
		assert 1==c.size();
		c.put("b", "1");
		assert 2==c.size();
		c.put("c", "1");
		assert 3==c.size();
		c.put("d", "1");
		assert 4==c.size();*/
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
	}
}

