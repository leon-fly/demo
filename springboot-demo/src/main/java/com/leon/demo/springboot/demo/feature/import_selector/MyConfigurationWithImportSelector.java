package com.leon.demo.springboot.demo.feature.import_selector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/4
 */
@Configuration
@Import(value = MyImportSelector.class)
public class MyConfigurationWithImportSelector {
}
