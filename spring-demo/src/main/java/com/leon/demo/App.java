package com.leon.demo;

import com.leon.demo.service.ServiceImplNone;
import com.leon.demo.service.interface_.GenericService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.leon.demo")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.leon.demo");
        GenericService genericService = context.getBean(GenericService.class);
        genericService.sayHello("how are you ~");
        System.out.println(genericService.getClass());

        System.out.println("------------------------------------------------------");

        ServiceImplNone serviceImplNone = context.getBean(ServiceImplNone.class);
        serviceImplNone.sayHello("how are you ~");
        System.out.println(serviceImplNone.getClass());

        System.out.println("------------------------------------------------------");
        serviceImplNone.methodWithReturn();

        System.out.println("------------------------------------------------------");
        serviceImplNone.methodWithThrow();
    }
}
