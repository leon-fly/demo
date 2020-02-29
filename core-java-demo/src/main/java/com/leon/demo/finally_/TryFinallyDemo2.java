package com.leon.demo.finally_;

/**
 * @Author : leonwang
 * @Descpriction 手动停止应用finally并不能得到执行
 * @Date:created 2020/2/22
 */
public class TryFinallyDemo2 {
    public static void main(String[] args) {
        TryFinallyDemo2 demo = new TryFinallyDemo2();
        demo.testBreakDown();
    }


    public void testBreakDown(){
        try{
            System.out.println("start...");
            Thread.currentThread().sleep(100000); //睡眠过程中停止应用
            System.out.println("finished...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("finally...");
        }
    }


}
