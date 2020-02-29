package com.leon.demo.message.rabbitmq.producers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/5
 */
@Component
public class Producer {
    @Autowired
    private AmqpTemplate rabbitmqTemplate;


    public void send(String message) {
        rabbitmqTemplate.convertAndSend("hello-spring-cloud", message);
    }
}
