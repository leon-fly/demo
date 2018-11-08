package com.leon.demo.consumer;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@Component
public class MessageConsumer {

    @Consume(uri="direct:hi")
    public String answer(String message){
        return "I got a '"+message+"'";
    }

    @Consume(uri="direct:doubleValue")
    public String doubleValue(String a){
        try{
            Integer.valueOf(a);
        }catch(Exception e){
            return "wrong input";
        }
        return "double value is '"+(Integer.valueOf(a)*2)+"'";
    }

    @Consume(uri = "seda:in?concurrentConsumers=10")
    public void report(String message){

    }

}
