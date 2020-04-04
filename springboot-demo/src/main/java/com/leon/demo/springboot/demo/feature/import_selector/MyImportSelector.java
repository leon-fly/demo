package com.leon.demo.springboot.demo.feature.import_selector;

import com.leon.demo.springboot.demo.bean.NormalBeanA;
import com.leon.demo.springboot.demo.bean.NormalBeanC;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/4
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{NormalBeanA.class.getName(), NormalBeanC.class.getName()};
    }
}
