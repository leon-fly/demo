package com.leon.demo.reflection;

import com.leon.bean.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author : leonwang
 * @Descpriction  google的guava和spring、apache都提供了对应都反射工具类
 * @Date:created 2020/3/6
 */

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> peopleClass = (Class<People>) Class.forName("com.leon.bean.People");

        Method[] methods= peopleClass.getMethods();
        System.out.println("获取方法-----------------");
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("获取构造函数------------------");
        Constructor<?>[] constructors = peopleClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("获取属性-------------------");
        Field[] fields = peopleClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }


        Object object = peopleClass.getConstructor().newInstance();
        Method set = peopleClass.getMethod("setName", String.class);
        Method get = peopleClass.getMethod("getName");

        set.setAccessible(true); //跳过访问权限检查，提高反射处理所读
        set.invoke(object, "leon");

        set.setAccessible(true);
        System.out.println("调用get："+get.invoke(object));

        //私有方法不能访问
        Method priMethod = peopleClass.getMethod("priMethod");
        priMethod.setAccessible(true);
        priMethod.invoke(object);

    }
}
