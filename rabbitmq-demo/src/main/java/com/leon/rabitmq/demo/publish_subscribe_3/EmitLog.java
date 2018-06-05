package com.leon.rabitmq.demo.publish_subscribe_3;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 发送日志信息的类，信息发送至交换组件
 * @author leonwang
 *
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv)
                  throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout",true,true,null);  //声明一个fanout类型的交换组件
        String message = "log content";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();
    }
    //...
}