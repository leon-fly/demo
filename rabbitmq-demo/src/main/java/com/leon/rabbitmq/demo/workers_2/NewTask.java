package com.leon.rabbitmq.demo.workers_2;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

	private static final String TASK_QUEUE_NAME = "queue.task";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

		String message = "任务";
		int send_times = 10000; // 发送任务次数
		for (int i = 0; i < send_times; i++) {
			Thread.sleep(100);
			String messagetemp = message+i+".";
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
					messagetemp.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + messagetemp + "'");
		}

		channel.close();
		connection.close();
	}
}
