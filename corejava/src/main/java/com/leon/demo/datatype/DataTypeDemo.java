package com.leon.demo.datatype;

public class DataTypeDemo {
    public static void main(String[] args) {
        //jdk1.7之后可以使用二进制字面量,数字字面量可以出现下划线
        int obnum = 0b0100;
        int numwith_ = 1_1234_0100;
        System.out.println(obnum+"=="+numwith_);
    }
}
