package com.leon.demo.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/30
 */
@RestController("/spring-cloud-demo/config-client/")
public class ConfigController {
    @Value("${id}")
    private String id;

    @GetMapping("config")
    public String getApiConfig(){
        return "app id:" + id;
    }
}
