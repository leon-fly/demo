package com.leon.demo.proxy.dynamic_.java;

import com.leon.demo.proxy.BusinessComponent;
import com.leon.demo.proxy.impl.BusinessComponentImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author : leonwang
 * @Descpriction jdk动态代理对象必须有实现的接口
 * @Date:created 2019/9/25
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        final BusinessComponent target = new BusinessComponentImpl();

        BusinessComponent proxy = (BusinessComponent) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{BusinessComponent.class}, new DynamicProxy(target));

        proxy.work();
    }
}

/**
 * 一定要有被代理对象
 */
class DynamicProxy implements InvocationHandler {
    private Object target;

    DynamicProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy--工作开始时间>>>" + System.currentTimeMillis());
        Object result = method.invoke(target, null);
        System.out.println("Proxy--工作结束时间>>>" + System.currentTimeMillis());
        return result;
    }
}
