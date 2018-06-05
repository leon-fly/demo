package com.leon.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springboot-web-demo")
public class ControllerTest {
	@RequestMapping("/hello-jsp")
	public String index(){
		System.out.println("into index===");
		return "index";
	}
	@RequestMapping("/hello-jsp-withmess")
	public ModelAndView indexWithMess(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("mess", "message from service~");
		return mv;
	}
}
