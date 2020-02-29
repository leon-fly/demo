package com.leon.demo.message.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/1/5
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello-spring-cloud");
    }

}
