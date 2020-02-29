package com.leon.rabbitmq.demo.publish_subscribe_3;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author : leonwang
 * @Descpriction  与ReceiveLogs不同的是队列名称是指定的，支持集群模式
 * @Date:created 2019/11/11
 */
public class ReceiveLogsClusterMode {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", true, true, null); //声明一个交换组件

        //指定队列名称可支持集群模式
        // ********************************************//
        String queueName = channel.queueDeclare("APP-LOG", false, false, true, null).getQueue();  //获得一个队列
        // ********************************************//

        channel.queueBind(queueName, EXCHANGE_NAME, "");  //将队列绑定到交换组件上，不使用路由键匹配
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
