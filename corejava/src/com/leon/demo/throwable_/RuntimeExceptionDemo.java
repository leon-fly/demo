package com.leon.demo.throwable_;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/7/23
 */
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        int i = testRuntimeException();
        System.out.println("rtn:"+i);
        testRuntimeException2();
    }

    public static int testRuntimeException(){
        try{
            throw new RuntimeException("runtimeException");
        }finally {
            System.out.println("finally");
            return 1;
        }
    }
    public static void testRuntimeException2(){
        try{
            throw new RuntimeException("runtimeException");
        }finally {
            System.out.println("finally");
        }
    }
}

