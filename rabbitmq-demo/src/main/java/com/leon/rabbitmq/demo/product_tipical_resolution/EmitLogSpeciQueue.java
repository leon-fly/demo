package com.leon.rabbitmq.demo.product_tipical_resolution;

import java.util.concurrent.TimeoutException;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogSpeciQueue {
	private static final String EXCHANGE_NAME = "logs"; // 指定队列的exchange

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); // 声明一个fanout类型的交换组件
		String message = "log content";
		for (int i = 0; i < 10; i++) {
			message = "log content" + i;
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
		channel.close();
		connection.close();
	}
}
