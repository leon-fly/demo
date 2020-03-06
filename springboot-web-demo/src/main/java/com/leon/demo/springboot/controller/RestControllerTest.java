package com.leon.demo.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/1
 */
@RestController
public class RestControllerTest {

    @RequestMapping(value = "/test")
    public String hello(){
        return "hello";
    }

}
