package com.leon.demo.spi.animal;

import com.leon.demo.spi.Speaker;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/1
 */
public class Cat implements Speaker {
    @Override
    public void sayHello() {
        System.out.println("miao ~");
    }
}
