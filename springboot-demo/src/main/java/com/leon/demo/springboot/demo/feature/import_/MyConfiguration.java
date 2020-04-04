package com.leon.demo.springboot.demo.feature.import_;

import com.leon.demo.springboot.demo.bean.NormalBeanA;
import com.leon.demo.springboot.demo.bean.NormalBeanB;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author : leonwang
 * @Descpriction spring的bean配置类，使用Import来导入一个普通java bean，spring的上下文中将能访问到import中的类
 * @Date:created 2020/4/4
 */
@Import(value = {NormalBeanA.class, NormalBeanB.class})
@Configuration
public class MyConfiguration {

}
