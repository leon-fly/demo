package com.leon.demo.designpattern.create;

/**
 * 原型模式：用原型实例指定创建对象的种类,并且通过拷贝这些原型创建新的对象.
 * 
 * @author leonwang
 *
 */
public class ProtypeDemo {
public static void main(String[] args) {
	AbstractSpoon spoon = new SoupSpoon();
	AbstractSpoon spoon2 = new SaladSpoon();
	
	AbstractSpoon spoon_copy =  (AbstractSpoon) spoon.clone();
	AbstractSpoon spoon2_copy = (AbstractSpoon) spoon2.clone();
	System.out.println(spoon+"-------"+spoon_copy);
	System.out.println(spoon2+"-------"+spoon2_copy);
}
}

abstract class AbstractSpoon implements Cloneable {
	String spoonName;

	public void setSpoonName(String spoonName) {
		this.spoonName = spoonName;
		System.out.println("spoonName:"+spoonName);
	}

	public String getSpoonName() {
		return this.spoonName;
	}

	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException exception) {
			System.err.println("AbstractSpoon is not Cloneable");
		}
		return object;
	}
}

class SoupSpoon extends AbstractSpoon {
	public SoupSpoon() {
		setSpoonName("Soup Spoon");
	}
}

class SaladSpoon extends AbstractSpoon {
	public SaladSpoon() {
		setSpoonName("Salad Spoon");
	}
}
