package com.leon.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/2/22
 */
public class ReentrantLockDemo {
    private String sharedResource;

    private ReentrantLock sharedResourceLock = new ReentrantLock(true);

    public void op1(){
        try {
            sharedResourceLock.lock();
            sharedResource = "sr";
        }finally {
            sharedResourceLock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedImpl synchronizeImpl = new SynchronizedImpl();
        synchronizeImpl.op1();
    }
}




/**
 *  同线程Synchronized方法调用Synchronized方法单Synchronized层面的锁不会产生死锁
 */
class SynchronizedImpl {

    private String sharedResource;

    synchronized void op1(){
        System.out.println("op1...");
        sharedResource = "sr";
        op2();
    }

    synchronized void op2(){
        System.out.println("op2...");
        System.out.println("op2 print: " + sharedResource);
    }

}
