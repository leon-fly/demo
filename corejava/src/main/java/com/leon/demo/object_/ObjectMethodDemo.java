package com.leon.demo.object_;

public class ObjectMethodDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableClass cc = new CloneableClass(5);
		CloneableClass cc2 = (CloneableClass) cc.clone();
		System.out.println(cc2.getA());
		System.out.println(cc.equals(cc2));
	}
}

/**
 * 要使用clone方法的类必须实现Cloneable方法表示可被clone，否则java.lang.CloneNotSupportedException
 * Cloneable接口为空接口
 * @author leonwang
 *
 */
class CloneableClass implements Cloneable{
	private int a;
	public CloneableClass(int a){
		this.a = a;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}