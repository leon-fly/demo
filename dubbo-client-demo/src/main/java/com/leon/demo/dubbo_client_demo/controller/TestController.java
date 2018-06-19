package com.leon.demo.dubbo_client_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leon.demo.dubbo_api_demo.service.HelloService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Reference(group="test", version = "1.0") 
	HelloService hs;
	@RequestMapping("/invoke")
	public String invokeDubboService(String serviceName){
		String cont = hs.sayHello("leon");
		return "invoke success,cont["+cont+"]";
	}
}