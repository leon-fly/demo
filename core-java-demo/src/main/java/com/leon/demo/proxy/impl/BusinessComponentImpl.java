package com.leon.demo.proxy.impl;

import com.leon.demo.proxy.BusinessComponent;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/9/25
 */
public class BusinessComponentImpl implements BusinessComponent {
    @Override
    public void work() {
        System.out.println("BusinessComponentImpl work...");
    }
}
