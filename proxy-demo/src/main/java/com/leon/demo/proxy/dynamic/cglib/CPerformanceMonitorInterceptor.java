package com.leon.demo.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/27
 */
public class CPerformanceMonitorInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(String.format("性能监控开始,class:%s, method：%s", o.getClass().getName(), method.getName()));
        long start = System.currentTimeMillis();

        Object obj = methodProxy.invokeSuper(o, objects);

        long end = System.currentTimeMillis();
        System.out.println(String.format("性能监控结束,耗时：%d ms, class:%s, method：%s", end - start, o.getClass().getName(), method.getName()));
        System.out.println("执行结果：" + obj);
        return obj;
    }
}
