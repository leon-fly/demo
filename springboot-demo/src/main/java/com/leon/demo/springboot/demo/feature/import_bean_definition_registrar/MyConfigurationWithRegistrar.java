package com.leon.demo.springboot.demo.feature.import_bean_definition_registrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/4
 */

@Configuration
@Import(value = MyImportBeanDefinitionRegistrar.class)
public class MyConfigurationWithRegistrar {
}
