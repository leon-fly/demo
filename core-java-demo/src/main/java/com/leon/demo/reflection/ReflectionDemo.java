package com.leon.demo.reflection;

import com.leon.bean.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author : leonwang
 * @Descpriction google的guava和spring、apache都提供了对应都反射工具类
 * @Date:created 2020/3/6
 */

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Class<?> peopleClass = (Class<People>) Class.forName("com.leon.bean.People");

        System.out.println("获取类的所有public方法-----------------");
        Method[] methods = peopleClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("获取本类中全部访问权限的方法，但不包括父类的方法-----------------");
        Method[] declaredMethods = peopleClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
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


        get.setAccessible(true);
        System.out.println("调用get：" + get.invoke(object));
        Field field = peopleClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("反射获取属性值：" + field.get(object));

        //私有方法访问
        Method priMethod = peopleClass.getDeclaredMethod("priMethod", null);
        priMethod.setAccessible(true);
        priMethod.invoke(object);

    }
}
