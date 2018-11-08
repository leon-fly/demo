package com.leon.demo.producer;

import com.leon.demo.configuration.MyConfig;
import com.leon.demo.utility.SpringApplicationContext;
import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@Component
public class MessageProducer {
    @Autowired
    private ProducerTemplate producerTemplate;

    public String sayHi(String name){
        return producerTemplate.requestBody("direct:hi",
                name, String.class);
    }

    public String doubleValue(String num){
        return producerTemplate.requestBody("direct:doubleValue",
                num, String.class);
    }


}
