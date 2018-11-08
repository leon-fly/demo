package com.leon.demo.configuration;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@Configuration
public class MyConfig {
   /* @Autowired
    private CamelContext camelContext;

    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }*/

//    @Bean
//    CamelContextConfiguration contextConfiguration() {
//        return new CamelContextConfiguration() {
//            @Override
//            void beforeApplicationStart(CamelContext context) {
//                // your custom configuration goes here
//            }
//        };
//    }
}
