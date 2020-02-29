package com.leon.demo.feign.eureka.consumer.controller;

import com.leon.demo.feign.eureka.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/4
 */

@RestController
@RequestMapping("/spring-cloud-demo/reign-eureka-consumer")
public class FeignController {
    @Autowired
    public HelloService helloService;

    @RequestMapping("consume")
    public String invokeEurekaService() {
        System.out.println("FeignController is called....");
        return "via feign-eureka-consumer->"+helloService.hello();
    }
}
