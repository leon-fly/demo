package com.leon.demo.springboot.demo.feature.smart_initializing_singleton;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author : leonwang
 * @Descpriction 单例被实例化后会被调用afterSingletonsInstantiated方法,会在@PostConstruct之后执行
 * @Date:created 2020/4/6
 */
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("================ MySmartInitializingSingleton was Instantiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("================ MySmartInitializingSingleton PostConstruct");
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("================ MySmartInitializingSingleton will be destroy");
    }
}
