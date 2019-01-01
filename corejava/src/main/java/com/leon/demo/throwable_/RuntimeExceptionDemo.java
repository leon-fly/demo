package com.leon.demo.throwable_;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/7/23
 */
public class RuntimeExceptionDemo {
    public static void main(String[] args) {
        int i = testFinallyWithReturn();
        System.out.println("rtn:"+i);

        testFinallyWithoutReturn();
    }

    public static int testFinallyWithReturn(){
        try{
            throw new RuntimeException("runtimeException");
        }finally {
            System.out.println("finally");
            return 1;
        }
    }
    public static void testFinallyWithoutReturn(){
        try{
            throw new RuntimeException("runtimeException");
        }finally {
            System.out.println("finally");
        }
    }
}

