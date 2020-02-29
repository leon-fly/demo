package com.leon.demo.algorithm;

/**
 * @Author : leonwang
 * @Descpriction 兔子问题(斐波那契数列)
 * @Date:created 2019/12/14
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(50));  //耗时，耗栈空间
        System.out.println(fibonacci2(50)); //时间和空间均衡
        System.out.println(fibonacci3(50)); //耗堆空间
    }


    public static long fibonacci(int n) {
        if (n > 2) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        return n == 0 ? 0 : 1;
    }

    public static long fibonacci2(int n) {
        long fibonacci = 0;

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        long tempA = 1;
        long tempB = 1;
        for (int i = 3; i <= n; i++) {
            fibonacci = tempA + tempB;
            tempA = tempB;
            tempB = fibonacci;
        }

        return fibonacci;
    }

    public static long fibonacci3(int n) {
        long[] fibonacciArray = new long[n];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        fibonacciArray[2] = 1;
        for (int i = 3; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        return fibonacciArray[n - 1];
    }
}
