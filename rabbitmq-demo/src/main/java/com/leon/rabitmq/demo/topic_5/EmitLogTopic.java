package com.leon.rabitmq.demo.topic_5;

import java.util.ArrayList;

import com.leon.rabitmq.demo.routing_4.LogModel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Topic类型的exchange，首先将话题分为多个维度的属性，发送消息时指定好routingkey的值，值为该信息的维度属性归类，属性值间用“.”分割，在消费端使用“*”及“#”两类通配符指定队列routingkey分别匹配对应的话题。
 * @author leonwang
 *
 */
public class EmitLogTopic {

	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "topic");

		ArrayList<LogModel> lms = new ArrayList<>();
		lms.add(new LogModel(LogModel.LOG_LEVEL_INFO, "Here is some [trade INFO] for u~", LogModel.LOG_TYPE_TRADE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_INFO, "Here is some [service WARNING] for u~",
				LogModel.LOG_TYPE_SERVICE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_INFO, "Here is some [func WARNING] for u~", LogModel.LOG_TYPE_FUNC));

		lms.add(new LogModel(LogModel.LOG_LEVEL_WARNING, "Here is some [trade WARNING] for u~",
				LogModel.LOG_TYPE_TRADE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_WARNING, "Here is some [service WARNING] for u~",
				LogModel.LOG_TYPE_SERVICE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_WARNING, "Here is some [func WARNING] for u~", LogModel.LOG_TYPE_FUNC));

		lms.add(new LogModel(LogModel.LOG_LEVEL_ERROR, "Here is some [trade ERROR] for u~", LogModel.LOG_TYPE_TRADE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_ERROR, "Here is some [service ERROR] for u~",
				LogModel.LOG_TYPE_SERVICE));
		lms.add(new LogModel(LogModel.LOG_LEVEL_ERROR, "Here is some [func ERROR] for u~", LogModel.LOG_TYPE_FUNC));

		for (LogModel logModel : lms) {
			String routingKey = logModel.getLogLevel() + "." + logModel.getLogType();
			String message = logModel.getMessage();

			channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
			System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

		}
		connection.close();
	}
	// ...
}
