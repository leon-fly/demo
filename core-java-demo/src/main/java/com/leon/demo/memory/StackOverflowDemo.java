package com.leon.demo.memory;

/**
 * @Author : leonwang
 * @Descpriction -Xss 配置栈空间，每个线程的私有栈空间。
 * @Date:created 2019/12/26
 */
public class StackOverflowDemo {
    public static void main(String[] args) {
        invokeSelf(1);
    }


    // 调用层次过多会导致栈溢出
    public static void invokeSelf(int i) {
        System.out.println("self:" + i);
        invokeSelf(++i);
    }
}
