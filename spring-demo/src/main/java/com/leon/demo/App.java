package com.leon.demo;

import com.leon.demo.service.GenericService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.leon.demo")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.leon.demo");
        GenericService genericService = context.getBean(GenericService.class);
        genericService.sayHello("how are you ~");
    }
}
