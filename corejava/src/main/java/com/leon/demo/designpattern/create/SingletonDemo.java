package com.leon.demo.designpattern.create;

public class SingletonDemo {
	public static void main(String[] args) {
		SingletonHungry st = SingletonHungry.getInstance();
		st.dosomething();
		
		SingletonLazy stl = SingletonLazy.getInstance();
		stl.dosomething();
	}
}


/**
 * 单例设计模式 - 饿汉式
 * 在初始化时
 * @author leonwang
 *
 */
class SingletonHungry{
	private static SingletonHungry st = new SingletonHungry();  //key私有静态
	private SingletonHungry(){  // 私有构造方法
		System.out.println("初始化...");
	}
	public static SingletonHungry getInstance(){  //共有静态
		System.out.println("调用getInstance....");
		return st;
	}
	public void dosomething(){
		System.out.println("dosomething");
	}
}

/**
 * 懒汉式 对象在使用时才创建
 * @author leonwang
 *
 */
class SingletonLazy{
	private static SingletonLazy st;
	private SingletonLazy() {
		System.out.println("初始化...");
	}
	/**
	 * 存在多线程安全问题
	 * @return
	 */
	/*public static SingletonLazy getInstance(){
		if(st == null)
			st = new SingletonLazy();
		return st;
	}*/
	/**
	 * 线程安全，效率低
	 * @return
	 */
	/*public synchronized static SingletonLazy getInstance(){
		if(st == null)
			st = new SingletonLazy();
		return st;
	}*/
	public synchronized static SingletonLazy getInstance(){
		if(st == null){
			synchronized (SingletonLazy.class) {
				if(st == null)
					st = new SingletonLazy();
			}
		}
		return st;
	}
	public void dosomething(){
		System.out.println("dosomething");
	}
	
}