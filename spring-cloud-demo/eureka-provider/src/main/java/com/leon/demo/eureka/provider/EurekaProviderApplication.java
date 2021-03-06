package com.leon.demo.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProviderApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaProviderApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
