package com.leon.demo.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/1/20
 */
@RestController
public class ConfigTestController extends BaseController {
    @Value("${id}")
    private String id;

    @GetMapping("config")
    public String getApiConfig(){
        return "app id:" + id;
    }
}
