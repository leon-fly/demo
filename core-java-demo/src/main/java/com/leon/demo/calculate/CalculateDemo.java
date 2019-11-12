package com.leon.demo.calculate;

/**
 * 运算测试Demo
 * 与运算 两位相位都是1则为1，否则为0
 * 或运算 只要有1个相位为1则为1，否则为0
 * 异或运算  参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。  0^0=0；   0^1=1；   1^0=1；   1^1=0；
 * 移位运算
 */
public class CalculateDemo {
    public static void main(String[] args) {
        test01();
        test02();

        Integer a = 0xaa;
        Integer b = 0x55;

        System.out.println(Integer.toHexString(a) + "的十进制为：" + a + ",八进制为：" + Integer.toOctalString(a) + ",二进制为：" + Integer.toBinaryString(a));
        System.out.println(Integer.toHexString(b) + "的十进制为：" + b + ",八进制为：" + Integer.toOctalString(b) + ",二进制为：" + Integer.toBinaryString(b));

        System.out.println(Integer.toBinaryString(a | b)); //或运算  按位有一个1则为1

        System.out.println(Integer.toBinaryString(a & b)); //与运算  按位有一个0则为0

        System.out.println(10 ^ 12); //异或运算，按位，有一个1为1，两个1则为0

    }

    /**
     * 正负数表示 正数的高位为0 负数的高位为1（当看到高位为1时可知为负数，采用的是补码方式表示，根据补码反算出原码即为该负数的绝对值）
     * 负数采用的是正数的补码表示（按位取反为反码，反码+1即为原码的补码）
     */
    public static void test01() {
        System.out.println("**************************************************************");
        System.out.println("3 二进制" + Integer.toBinaryString(3));  //Integer为32位
        System.out.println("-3 二进制" + Integer.toBinaryString(-3));
    }

    /**
     * 移位运算
     */
    public static void test02() {
        System.out.println("**************************************************************");

        System.out.println("2的二进制：" + Integer.toBinaryString(2));
        System.out.println("5的二进制：" + Integer.toBinaryString(5));

        System.out.println("2 >> 1 = " + (2 >> 1));
        System.out.println("5 >> 1 = " + (5 >> 1));

        System.out.println("-2 >> 1 = " + (-2 >> 1));
        System.out.println("-5 >> 1 = " + (-5 >> 1));

        System.out.println("-2 >>> 1 = " + (Integer.toBinaryString(-2 >>> 1)));
        System.out.println("-5 >>> 1 = " + (Integer.toBinaryString(-5 >>> 1)));

        System.out.println(1 << 1);
        System.out.println(2 << 1);
        System.out.println(3 << 1);
        System.out.println(2 >> 1);
        System.out.println(3 >> 1);
        System.out.println(4 >> 1);
    }
}
