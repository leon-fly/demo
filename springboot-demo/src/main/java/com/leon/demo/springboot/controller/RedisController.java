package com.leon.demo.springboot.controller;

import com.leon.demo.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/21
 */
@RestController
public class RedisController {
    @Autowired
    RedisService redisService;

    @RequestMapping("/redis")
    public String test(@RequestParam(required = false) String key, @RequestParam(required = false) String value) {
        redisService.test(key, value);
        return "ok";
    }
}
