package com.leon.demo.dubbo_service_demo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.leon.demo.dubbo_api_demo.service.HelloService;


//@Component  //此注解无用
@Service(group="test", version = "1.0") 
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello(String name) {
		String content = "hi,"+name;
		System.out.println(content);
		return content;
	}

}
