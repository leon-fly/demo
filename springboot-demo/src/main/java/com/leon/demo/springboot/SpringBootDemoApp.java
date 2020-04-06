package com.leon.demo.springboot;

import com.leon.demo.springboot.controller.HelloController;
import com.leon.demo.springboot.dao.ProductInfoDao;
import com.leon.demo.springboot.model.po.ProductInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringBootDemoApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(SpringBootDemoApp.class, args);
        System.out.println( "service ready" );
    }
}
