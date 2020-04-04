package com.leon.demo.springboot.demo.feature.import_bean_definition_registrar;

import com.leon.demo.springboot.demo.bean.NormalBeanA;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author : leonwang
 * @Descpriction 手动注册bean到容器中
 * @Date:created 2020/4/4
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition = new RootBeanDefinition(NormalBeanA.class);
        registry.registerBeanDefinition("normalBeanA", beanDefinition);
    }
}
