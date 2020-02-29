package com.leon.rabbitmq.demo.confirm;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/5
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(ServiceConstant.HOST_NAME);
        connectionFactory.setPort(ServiceConstant.PORT_CLUSTER);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();


        String queueName = "queue.test.confirm";
        channel.queueDeclare(queueName, true, false, false, null);

        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(String.format("ack, deliveryTag:%s, multiple:%s", deliveryTag, multiple));
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(String.format("nack, deliveryTag:%s, multiple:%s", deliveryTag, multiple));
            }
        });

        String msg = "hi, here is a message need to be confirmed !";

        for (int i = 0; i < 10000000; i++) {
            channel.basicPublish("", queueName, null, msg.getBytes());
            Thread.currentThread().sleep(100);
        }
    }
}
