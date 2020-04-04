package com.leon.demo.springboot.demo.feature.import_selector;

import com.leon.demo.springboot.demo.bean.NormalBeanA;
import com.leon.demo.springboot.demo.bean.NormalBeanC;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/4
 */
@SpringBootApplication
@ComponentScan("com.leon.demo.springboot.demo.feature.import_selector")
public class ImportSelectorDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportSelectorDemo.class);
        applicationContext.getBean(NormalBeanA.class).sayHi();
        applicationContext.getBean(NormalBeanC.class).sayHi();
    }
}
