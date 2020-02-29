package com.leon.rabbitmq.demo.topic_5;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogsTopic {
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		String queueName = channel.queueDeclare().getQueue();
		
		String[] bindingKeys = new String[]{"error.*"}; //error类型的所有信息 
//		String[] bindingKeys = new String[]{"error.*","*.trade"}; //error类型和trade类型的所有信息
//		String[] bindingKeys = new String[]{"#"}; //所有信息
		
		for (String bindingKey : bindingKeys) {
			channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
		}

		System.out.println(" [ReceiveLogsTopic] Waiting for messages. To exit press CTRL+C");

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
