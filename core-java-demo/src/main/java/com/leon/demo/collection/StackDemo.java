package com.leon.demo.collection;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        int n = 5 - 1;
        n |= n >>> 1;

        System.out.println(n);
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n);
        System.out.println((n < 0) ? 1 : n + 1);

        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
//		int ind = 0;
        int ssize = s.size();
        for (int a = 0; a < ssize; a++) {
            System.out.println("第" + a + "个数据是" + s.pop());
        }

    }
}
