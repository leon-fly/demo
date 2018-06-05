package com.leon.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//SpringBootServletInitializer有什么用
@SpringBootApplication
public class AppleApplication extends SpringBootServletInitializer{
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppleApplication.class);
    }
	
    public static void main(String[] args) {
    	ConfigurableApplicationContext  context=SpringApplication.run(AppleApplication.class, args);  
        String applicationproperties  = context.getEnvironment().getProperty("spring.mvc.view.prefix");
        System.out.println("applicationproperties-->"+applicationproperties);
    }
}

//采用application.properties的方式找不到jsp文件，需要建立继承WebMvcConfigurerAdapter的类并注解配置
/*@SpringBootApplication
public class AppleApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext  context=SpringApplication.run(AppleApplication.class, args);  
        String applicationproperties  = context.getEnvironment().getProperty("spring.mvc.view.prefix");
        System.out.println("applicationproperties-->"+applicationproperties);
    }
}*/
