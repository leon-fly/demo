package com.leon.demo.controller;

import com.leon.demo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@RestController
public class TestController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/test/{method}")
    public String test(@PathVariable("method") String method, @RequestBody String content){
        System.out.println("method:"+method+"request:"+content);
        String answer;
        if ("1".equals(method)) {
            answer = messageProducer.sayHi(content);
        }else{
            answer = messageProducer.doubleValue(content);
        }
        System.out.println("response:"+answer);
        return answer;
    }
}
