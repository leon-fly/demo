package com.leon.demo.abstract_interface.abstract_method_error_test;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/1
 */
public class ClassB extends AbClassA{
    @Override
    public void hello() {
        System.out.println("son class");
    }

    public static void main(String[] args) {
        AbClassA a = new ClassB();
        a.hello();
    }
}
