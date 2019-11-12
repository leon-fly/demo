package com.leon.demo.quote;

import com.leon.bean.People;
/**
 * java中基本数据类型为值传递，对象String为值传递，其他对象为引用传递，方法对对象做的修改影响原对象。
 * @author leonwang
 *
 */
public class QuotePassDemo implements Cloneable{
	int a = 0;
	public static void main(String[] args) {
		People p = new People("leon","M","123");
		setPeopleName(p);
		System.out.println(p.getName());
	}
	
	public static void setPeopleName(People people){  //引用传递，传递的引用的地址副本，修改内容为引用指向的对象
		people.setName("changedName");
	}
	
	public int getNum(int b){  //值传递，变量的副本，修改后不影响原变量
		b = 10;
		return b;
	}
	
}