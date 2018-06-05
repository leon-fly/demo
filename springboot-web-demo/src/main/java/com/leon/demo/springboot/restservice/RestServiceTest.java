package com.leon.demo.springboot.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/springboot-web-demo/services")
public class RestServiceTest {
	@RequestMapping("/hello-rest")
    public String hello() {
		System.out.println("into hello====");
        return "hello,this is test rest service content~";
    }
}