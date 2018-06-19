package com.leon.demo.abstract_interface;
/**
 * 
 * @author leonwang
 *
 */
public class ExtendsFeaturesDemo {
	public static void main(String[] args) {
		FatherC fa = new SonC();
		FatherI fi = new SonI();
		fa.proMethod();
		fi.pubMethod();
	}
}

abstract class FatherC{
//	private void priMethod(){
//		System.out.println("父类的私有方法");
//	}
	
	protected void proMethod(){
		System.out.println("父类的protected方法");
	}
}


class SonC extends FatherC {
//	private void priMethod(){
//		System.out.println("子类的私有方法");
//	}
	@Override
	public void proMethod() {
		System.out.println("子类SonC的protected方法");
	}
}

interface FatherI{
	//private void priMethod();   //不允许私有方法
	
	void pubMethod();
}

class SonI implements FatherI{

	@Override
	public void pubMethod() {
		System.out.println("子类SonI的pubMethod");
	}
	
}