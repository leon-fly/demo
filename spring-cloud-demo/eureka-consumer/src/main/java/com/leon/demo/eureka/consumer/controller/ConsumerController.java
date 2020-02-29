package com.leon.demo.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : leonwang
 * @Description
 * @Date : created  2019/1/10
 */
@RestController
@RequestMapping("/spring-cloud-demo/eureka-consumer")
public class ConsumerController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("hello-world")
    public String sayHelloWorld() {
        return "hello world";
    }

    @RequestMapping("good-bye")
    public String sayGoodBye() {
        return "good bye";
    }

    @RequestMapping("consume")
    public String invokeEurekaService() {
        System.out.println("ConsumerController is called....");
        return "via eureka consumer:" + restTemplate.getForEntity("http://EUREKA-PROVIDER/spring-cloud-demo/eureka-provider/hello-world", String.class).getBody();
    }

}
