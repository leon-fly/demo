package com.leon.demo.constructor;
/**
 * 子类的构造方法调用时会首先使用父类的无参构造方法，如果父类无无参构造将出错。当没有手动加入有参构造时，类会默认一个无参构造方法，如果手动编写了有参构造则应该同时手动增加无参构造。
 * @author leonwang
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		new SonC();
		System.out.println("===========");
		new SonC(10);
	}
}

class FatherC{
	public FatherC() {
		System.out.println("FatherC constructor");
	}
	public FatherC(int a) {
		System.out.println("FatherC constructor with args");
	}
}

class SonC extends FatherC{
	public SonC() {
		System.out.println("Sonc constructor");
	}
	public SonC(int a){
		System.out.println("Sonc constructor with args");
	}
}