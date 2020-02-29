package com.leon.demo.annotation_;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/2/9
 */
public class Student {
    private String sid;
    private String name;

    @Phone(type = PhoneType.CELL_PHONE)
    private String contact;
}
