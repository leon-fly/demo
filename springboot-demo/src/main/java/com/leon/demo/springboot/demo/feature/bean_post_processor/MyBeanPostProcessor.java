package com.leon.demo.springboot.demo.feature.bean_post_processor;

import com.leon.demo.springboot.demo.bean.SpringBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction BeanPostProcessor用于对实例化对类进行修改
 * @Date:created 2020/4/6
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBean && beanName.contains("springBean")) {
            ((SpringBean) bean).setPro1("postProcessBeforeInitialization");
            System.out.println(">>>>>>>>>>>>>>>>>>> MyBeanPostProcessor postProcessBeforeInitialization : " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBean && beanName.contains("springBean")) {
            ((SpringBean) bean).setPro2("postProcessAfterInitialization");
            System.out.println(">>>>>>>>>>>>>>>>>>> MyBeanPostProcessor postProcessAfterInitialization : " + bean);
        }
        return bean;
    }
}
