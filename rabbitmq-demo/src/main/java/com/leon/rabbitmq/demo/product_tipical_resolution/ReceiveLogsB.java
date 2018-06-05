package com.leon.rabbitmq.demo.product_tipical_resolution;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class ReceiveLogsB {
	private static final String EXCHANGE_NAME = "logs"; // 指定队列的exchange
	private static final String QUEUE_NAME_APP_B = "ReceiveLogsB"; // 应用B的队列名

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME_APP_B, true, false, true, null); // 声明一个队列 ReceiveLogsA
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); // 声明一个fanout类型的交换组件
		channel.queueBind(QUEUE_NAME_APP_B, EXCHANGE_NAME, "");
		System.out.println(" [*] ReceiveLogsB Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] ReceiveLogsB ["+ Thread.currentThread().getId() +"]received"+message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME_APP_B, true, consumer);
	}
}
