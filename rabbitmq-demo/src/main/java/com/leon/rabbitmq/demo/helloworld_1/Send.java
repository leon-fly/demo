package com.leon.rabbitmq.demo.helloworld_1;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * 模拟发消息客户端（消息生产者）
 *
 * @author leonwang
 */
public class Send {
    private final static String QUEUE_NAME = "queue.hello.world";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ServiceConstant.HOST_NAME);
        factory.setPort(ServiceConstant.PORT);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "";
        for (int i = 0; i < 10000; i++) {
            message = "Hello World, NO : " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent to [" + QUEUE_NAME + "]" + message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        channel.close();
        connection.close();
    }
}
