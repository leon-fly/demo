package com.leon.demo.moduleA.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : leonwang
 * @Description
 * @Date : created  2019/1/10
 */
@RestController
public class AController {
    @RequestMapping("/hello-world")
    public String sayHelloWorld(){
        return "hello world";
    }
}
