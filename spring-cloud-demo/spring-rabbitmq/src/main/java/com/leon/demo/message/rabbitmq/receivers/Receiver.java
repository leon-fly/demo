package com.leon.demo.message.rabbitmq.receivers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/5
 */
@Component
@RabbitListener(queues = "hello-spring-cloud")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Receive : " + message);
    }
}
