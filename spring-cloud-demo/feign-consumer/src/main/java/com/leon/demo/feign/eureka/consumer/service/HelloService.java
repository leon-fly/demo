package com.leon.demo.feign.eureka.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/4
 */
@FeignClient("EUREKA-PROVIDER")
public interface HelloService {
    @RequestMapping("/spring-cloud-demo/eureka-provider/hello-world")
    String hello();
}
