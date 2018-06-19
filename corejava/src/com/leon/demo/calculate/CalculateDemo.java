package com.leon.demo.calculate;

public class CalculateDemo {
	public static void main(String[] args) {
		Integer a = 0xaa;
		Integer b = 0x55;
        System.out.println(Integer.toHexString(a)+"的十进制为："+a+",八进制为："+Integer.toOctalString(a)+",二进制为："+Integer.toBinaryString(a));
        System.out.println(Integer.toHexString(b)+"的十进制为："+b+",八进制为："+Integer.toOctalString(b)+",二进制为："+Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a|b)); //或运算  按位有一个1则为1
        System.out.println(Integer.toBinaryString(a&b));//与运算 按位有一个0则为0
        System.out.println(10^12); //与或运算，按位，有一个1为1，两个1则为0
        System.out.println("-2 >> 1 = "+(-2 >> 1) );
        System.out.println("-5 >> 1 = "+(-5 >> 1));
        
        System.out.println(1<<1);
        System.out.println(2<<1);
        System.out.println(3<<1);
        System.out.println(2>>1);
        System.out.println(3>>1);
        System.out.println(4>>1);
       
	}
}
