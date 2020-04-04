package com.leon.demo.springboot.demo.feature.import_bean_definition_registrar;

import com.leon.demo.springboot.demo.bean.NormalBeanA;
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
@ComponentScan(value = "com.leon.demo.springboot.demo.feature.import_bean_definition_registrar")
public class ImportBeanDefinitionRegistrarDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportBeanDefinitionRegistrarDemo.class);
        applicationContext.getBean(NormalBeanA.class).sayHi();
    }
}
