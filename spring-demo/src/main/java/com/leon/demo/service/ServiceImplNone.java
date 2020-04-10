package com.leon.demo.service;

import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/10
 */
@Component
public class ServiceImplNone {
    public void sayHello(String content) {
        System.out.println("ServiceImplNone: hi , " + content);
    }

    public void methodWithThrow(){
        System.out.println("ServiceImplNone: methodWithThrow");
        throw new RuntimeException("我故意的...");
    }

    public MyBean methodWithReturn(){
        System.out.println("ServiceImplNone: methodWithReturn...");
        return new MyBean().setPro("my pro");
    }

    public static class MyBean {
        private String pro;

        public String getPro() {
            return pro;
        }

        public MyBean setPro(String pro) {
            this.pro = pro;
            return this;
        }
    }
}
