package com.leon.rabitmq.demo.routing_4;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogDirect {

	private static final String EXCHANGE_NAME = "direct_logs";

	public static void main(String[] argv) throws java.io.IOException, TimeoutException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "direct");

		ArrayList<LogModel> lms = new ArrayList<>();
		lms.add(new LogModel(LogModel.LOG_LEVEL_INFO, "Here is some infomation for u~"));
		lms.add(new LogModel(LogModel.LOG_LEVEL_WARNING, "Here is some WARNING infomation for u~"));
		lms.add(new LogModel(LogModel.LOG_LEVEL_ERROR, "Here is some ERROR infomation for u~"));
		for(LogModel md : lms){
			String severity = md.getLogLevel(); // 消息主题类型
			String message = md.getMessage();

			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
		}

		channel.close();
		connection.close();
	}
	// ..
}

