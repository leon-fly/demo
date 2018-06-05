package com.leon.demo.mem;

public class JVMMemDemo {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Leon");
		String food = "西瓜";
		p.eatSomething(food);
	}
}	

class Person{
	String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void eatSomething(String food){
		System.out.println(name+"吃"+food);
	}
}

