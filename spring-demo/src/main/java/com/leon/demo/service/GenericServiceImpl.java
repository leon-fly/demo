package com.leon.demo.service;

import com.leon.demo.service.interface_.GenericService;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/4/10
 */
@Component
public class GenericServiceImpl implements GenericService {
    @Override
    public void sayHello(String content) {
        System.out.println("GenericService ----->hi , " + content);
    }
}
