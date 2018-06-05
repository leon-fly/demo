package com.leon.demo.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * 这个类不配置jsp页面找不到，即使启动类继承了SpringBootServletInitializer并配置了application.properties也是存在问题的。问题待确认
 * @author leonwang
 *
 */
@Configuration
public class SpringMvcConfigure extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		System.out.println("view===================================");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		// viewResolver.setViewClass(JstlView.class); //
		// 这个属性通常并不需要手动配置，高版本的Spring会自动检测
		return viewResolver;
	}
}