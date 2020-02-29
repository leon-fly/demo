package com.leon.rabbitmq.demo.cluster;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 模拟发消息客户端（消息生产者）
 *
 * @author leonwang
 */
public class Send {
    private final static String QUEUE_NAME = "ha.mirror.hello.world";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ServiceConstant.HOST_NAME);
        factory.setPort(ServiceConstant.PORT_CLUSTER);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setAutomaticRecoveryEnabled(true);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        Map<String, Object> queueArgs = new HashMap();
        queueArgs.put("x-ha-policy", "all");
        channel.queueDeclare(QUEUE_NAME, true, false, false, queueArgs);
        String message = "";
        for (int i = 0; i < 10000; i++) {
            message = "Hello World, NO : " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent to [" + QUEUE_NAME + "]" + message);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        channel.close();
        connection.close();
    }
}
