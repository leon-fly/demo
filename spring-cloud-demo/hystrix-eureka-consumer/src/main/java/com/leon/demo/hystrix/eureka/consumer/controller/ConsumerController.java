package com.leon.demo.hystrix.eureka.consumer.controller;

import com.leon.demo.hystrix.eureka.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Description
 * @Date : created  2019/1/10
 */
@RestController
@RequestMapping("/spring-cloud-demo/hystrix-eureka-consumer")
public class ConsumerController {

    @Autowired
    public HelloService helloService;

    @RequestMapping("consume")
    public String invokeEurekaService() {
        System.out.println("HystrixConsumerController is called....");
        return "via hystrix-eureka-consumer->"+helloService.hello();
    }

}
