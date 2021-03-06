package com.leon.demo.design.creation;

import java.util.ArrayList;
import java.util.List;

public class BuilderDemo2 {
	public static void main(String[] args) {
		// 逛了很久终于发现一家合适的电脑店
		// 找到该店的老板和装机人员
		ComputerDirector director = new ComputerDirector();
		ComputerBuilder builder = new ConcreteComputerBuilder();

		// 沟通需求后，老板叫装机人员去装电脑
		director.Construct(builder);

		// 装完后，组装人员搬来组装好的电脑
		Computer computer = builder.getComputer();
		// 组装人员展示电脑给小成看
		computer.Show();

	}
}

abstract class ComputerBuilder {

	// 第一步：装CPU
	// 声明为抽象方法，具体由子类实现
	public abstract void buildCPU();

	// 第二步：装主板
	// 声明为抽象方法，具体由子类实现
	public abstract void buildMainboard();

	// 第三步：装硬盘
	// 声明为抽象方法，具体由子类实现
	public abstract void buildHD();

	// 返回产品的方法：获得组装好的电脑
	public abstract Computer getComputer();
}

class ComputerDirector {
	// 指挥装机人员组装电脑
	public void Construct(ComputerBuilder builder) {

		builder.buildCPU();
		builder.buildMainboard();
		builder.buildHD();
	}
}

class ConcreteComputerBuilder extends ComputerBuilder {
	// 创建产品实例
	Computer computer = new Computer();

	// 组装产品
	@Override
	public void buildCPU() {
		computer.add("组装CPU");
	}

	@Override
	public void buildMainboard() {
		computer.add("组装主板");
	}

	@Override
	public void buildHD() {
		computer.add("组装主板");
	}

	// 返回组装成功的电脑
	@Override
	public Computer getComputer() {
		return computer;
	}
}

class Computer {

	// 电脑组件的集合
	private List<String> parts = new ArrayList<String>();

	// 用于将组件组装到电脑里
	public void add(String part) {
		parts.add(part);
	}

	public void Show() {
		for (int i = 0; i < parts.size(); i++) {
			System.out.println("组件" + parts.get(i) + "装好了");
		}
		System.out.println("电脑组装完成，请验收");
	}

}