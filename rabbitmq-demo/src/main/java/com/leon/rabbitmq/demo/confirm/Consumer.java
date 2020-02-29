package com.leon.rabbitmq.demo.confirm;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/5
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(ServiceConstant.HOST_NAME);
        connectionFactory.setPort(ServiceConstant.PORT);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();

        final Channel channel = connection.createChannel();


        final String queueName = "queue.test.confirm";
        channel.queueDeclare(queueName, true, false, false, null);

        final DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                try {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received from [" + queueName + "] " + message);
                } finally {
                    System.out.println(" [consumer] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
//                    channel.basicReject(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
