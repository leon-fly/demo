package com.leon.demo.springboot.restservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/springboot-web-demo/services")
public class RestServiceTest {
	@RequestMapping("/hello-rest")
    public String hello(HttpServletRequest request, HttpServletResponse resp,HttpSession session) {
		
		System.out.println("into hello==== src ip="+request.getRemoteAddr());
        return "hello,this is test rest service content~";
    }
}
