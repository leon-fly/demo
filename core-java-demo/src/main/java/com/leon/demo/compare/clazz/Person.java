package com.leon.demo.compare.clazz;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/11/6
 */
public class Person implements Bean{

    private String name;

    @Override
    public String getLabel() {
        return "人";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
