package com.leon.demo.throwable_;

/**
 * @Author : leonwang
 * @Descpriction  finally是一定会捕获到到异常
 * @Date:created 2020/3/7
 */
public class TryDemo {
    public static void main(String[] args) {
        new TryDemo().testTry();
    }

    void testTry() {
        try {
            System.out.println("hello");
            methodWithRuntimeException();
            System.out.println("world");
        }finally {
            System.out.println("finally...执行结束");
        }
    }

    void methodWithRuntimeException(){
        throw new RuntimeException("exception");
    }
}
