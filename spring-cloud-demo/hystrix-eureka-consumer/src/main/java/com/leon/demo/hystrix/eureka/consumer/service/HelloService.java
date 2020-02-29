package com.leon.demo.hystrix.eureka.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/4
 */
@Service
public class HelloService {
    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello() {
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/spring-cloud-demo/eureka-provider/hello-world", String.class).getBody();
    }

    public String helloFallback() {
        return "error:server error or request out of time";
    }
}
