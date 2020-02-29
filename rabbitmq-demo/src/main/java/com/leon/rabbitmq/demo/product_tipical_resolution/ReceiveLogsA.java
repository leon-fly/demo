package com.leon.rabbitmq.demo.product_tipical_resolution;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiveLogsA {
	private static final String EXCHANGE_NAME = "logs"; // 指定队列的exchange
	private static final String QUEUE_NAME_APP_A = "ReceiveLogsA"; // 应用A的队列名

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME_APP_A, true, false, true, null); // 声明一个队列 ReceiveLogsA
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); // 声明一个fanout类型的交换组件
		channel.queueBind(QUEUE_NAME_APP_A, EXCHANGE_NAME, "");
		System.out.println(" [*] ReceiveLogsA Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] ReceiveLogsA ["+ Thread.currentThread().getId() +"]Received '" + message + "' " );
			}
		};
		channel.basicConsume(QUEUE_NAME_APP_A, true, consumer);
	}
}
