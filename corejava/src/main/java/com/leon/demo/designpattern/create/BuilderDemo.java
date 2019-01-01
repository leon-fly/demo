package com.leon.demo.designpattern.create;

/**
 * 建造者模式:将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示.解耦过程和部件。
 * 可参考https://blog.csdn.net/carson_ho/article/details/54910597
 * 
 * @author leonwang
 *
 */
public class BuilderDemo {
	public static void main(String[] args) {
		ConcreteBuilder builder = new ConcreteBuilder();
		Director director = new Director( builder );
		director.construct();
		/*Product product = */builder.getResult();
	}
}

interface Builder {
	// 创建部件A 比如创建汽车车轮
	void buildPartA();

	// 创建部件B 比如创建汽车方向盘
	void buildPartB();

	// 创建部件C 比如创建汽车发动机
	void buildPartC();

	// 返回最后组装成品结果 (返回最后装配好的汽车)
	// 成品的组装过程不在这里进行,而是转移到下面的Director 类中进行.
	// 从而实现了解耦过程和部件
	Product getResult();
}

class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	// 将部件partA partB partC 最后组成复杂对象
	// 这里是将车轮 方向盘和发动机组装成汽车的过程
	public void construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
	}
}

class ConcreteBuilder implements Builder {
	Part partA, partB, partC;

	public void buildPartA() {
		// 这里是具体如何构建partA 的代码
	};

	public void buildPartB() {
		// 这里是具体如何构建partB 的代码
	};

	public void buildPartC() {
		// 这里是具体如何构建partB 的代码
	};

	public Product getResult() {
		return null;
		// 返回最后组装成品结果
	};
}

interface Product { }
interface Part { }