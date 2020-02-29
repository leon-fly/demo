package com.leon.demo.design.creation;

/**
 * 简单工厂/工厂方法模式
 * 屏蔽产品生成过程，是生产和使用分离，这样当产品生产发生变动时无须大面积调整
 * @author leonwang
 *
 */
public class SimpleFactoryDemo2 {
	public static void main(String[] args) {
		FastFoodFactory.createChicken();
		FastFoodFactory.createHumburg();
	}
}

class FastFoodFactory{
	public static Chicken createChicken(){
		Chicken chicken = new Chicken();
		return chicken;
	}
	
	public static Hamburg createHumburg(){
		Hamburg hamburg = new Hamburg();
		return hamburg;
	}
}

class Chicken{
	public Chicken() {
		System.out.println("Chicken is created...");
	}
}

class Hamburg{
	public Hamburg() {
		System.out.println("Hamburg is created...");
	}
}