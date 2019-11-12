package com.leon.demo.proxy.dynamic_.cglib;

import com.leon.bean.People;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : leonwang
 * @Descpriction 被代理对象不能是final
 * @Date:created 2019/9/26
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        CglibProxyHandler cglibProxyHandler = new CglibProxyHandler();
        People people = new People();
        people.setName("Leon");
        People proxy = (People)cglibProxyHandler.createObject(people);
        proxy.stand();
    }

}


class CglibProxyHandler implements MethodInterceptor {

    /**
     * 代理对象
     */
    private Object targetObj;

    public Object createObject(Object obj) {
        this.targetObj = obj;
        Enhancer eh = new Enhancer();
        eh.setSuperclass(this.targetObj.getClass());
        eh.setCallback(this);
        return eh.create();
    }

    public Object intercept(Object obj, Method arg1, Object[] arg2,
                            MethodProxy proxy) throws Throwable {

        System.out.println("hi,target is ready now");
        Object object = proxy.invoke(this.targetObj, arg2);//这里如果换成obj 会陷入死循环中
        System.out.println("hi, target has ready done...");
        return object;
    }
}