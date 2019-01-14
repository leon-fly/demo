package com.leon.demo.moduleA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class AApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(AApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
