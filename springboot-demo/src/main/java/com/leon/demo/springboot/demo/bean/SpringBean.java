package com.leon.demo.springboot.demo.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/6
 */
@Setter
@Getter
@ToString
@Component
public class SpringBean implements SmartInitializingSingleton {
    private String pro1 ;
    private String pro2 ;

    @PostConstruct
    public void init() {
        System.out.println(">>>>>>>>>>>>>>>>>>> SpringBean init: " + this);
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println(">>>>>>>>>>>>>>>>>>> SpringBean afterSingletonsInstantiated : was Instantiated");
    }
}
