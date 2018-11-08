package com.leon.demo;

import com.leon.demo.routes.LogMessageOnTimerEventRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@SpringBootApplication
@ComponentScan({"com.leon.demo"})
@ImportResource({"classpath:spring/camel-context.xml"})
public class App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class);
        System.out.println("server running ...");
//        CamelContext context = new DefaultCamelContext();
//        context.addRoutes(
//                new LogMessageOnTimerEventRouteBuilder());
//        context.start();
    }
}
