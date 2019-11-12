package com.leon.rabitmq.demo.routing_4;

import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogsDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();
		
		/*String[] subscribeTopLowImpMsg = new String[]{LogModel.LOG_LEVEL_INFO,LogModel.LOG_LEVEL_WARNING};  //[info] [warning] [error]
		String[] subscribeTopHighImpMsg = new String[]{LogModel.LOG_LEVEL_ERROR};*/
        String[] subscribeTopAll = new String[]{LogModel.LOG_LEVEL_INFO, LogModel.LOG_LEVEL_WARNING, LogModel.LOG_LEVEL_ERROR};
        for (String severity : subscribeTopAll) {
            System.out.println("订阅主题：" + severity);
            channel.queueBind(queueName, EXCHANGE_NAME, severity);
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}

