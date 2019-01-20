package com.leon.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ApiApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ApiApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
