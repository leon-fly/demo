package com.leon.demo.design.creation;
/**
 * 
 * @author leonwang
 * 抽象工厂模式，与简单工厂模式的区别在于较简单工厂模式复杂，均面向抽象，工厂抽象，工厂生产的产品抽象，工厂子类和产品子类分别对其实现。
 * 比如：每个笔记本品牌需要自己的CPU,RAM,硬盘，或者每一家快餐店都需要有自己的汉堡、鸡腿、鸡翅等等
 *
 */
public class AbstractFactoryDemo {
	public static void main(String[] args) {
		ComputerFactory cf = new MACComputerFactory();
		cf.produceCPU();
		cf.produceRAM();
		System.out.println("--------------------");
		cf = new PCComputerFactory();
		cf.produceCPU();
		cf.produceRAM();
	}
}

/**
 * 电脑共产抽象
 * @author leonwang
 *
 */
interface ComputerFactory{
	public RAM produceRAM();
	public CPU produceCPU();
}
/**
 * RAM抽象
 * @author leonwang
 *
 */
interface RAM{
	
}
/**
 * CPU抽象
 * @author leonwang
 *
 */
interface CPU{
	
}

/**
 * PC的工厂及产品实现
 * @author leonwang
 *
 */
class PCRAM implements RAM{
	public PCRAM() {
		System.out.println("PCRAM is produced...");
	}
}
class PCCPU implements CPU{
	public PCCPU() {
		System.out.println("PCCPU is produced...");
	}
}
class PCComputerFactory implements ComputerFactory{

	@Override
	public RAM produceRAM() {
		return new PCRAM();
	}

	@Override
	public CPU produceCPU() {
		return new PCCPU();
	}
	
}


/**
 * mac的工厂及产品实现
 * @author leonwang
 *
 */

class MACRAM implements RAM{
	public MACRAM() {
		System.out.println("MACRAM is produced...");
	}
}
class MACCPU implements CPU{
	public MACCPU() {
		System.out.println("MACCPU is produced...");
	}
}
class MACComputerFactory implements ComputerFactory{

	@Override
	public RAM produceRAM() {
		return new MACRAM();
	}

	@Override
	public CPU produceCPU() {
		return new MACCPU();
	}
	
}

