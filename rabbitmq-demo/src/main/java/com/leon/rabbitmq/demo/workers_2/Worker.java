package com.leon.rabbitmq.demo.workers_2;

import com.leon.rabbitmq.demo.constant.ServiceConstant;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//类似于集群模式，过个节点共同处理任务，同一个任务只有一个节点在处理
public class Worker {

	private static final String TASK_QUEUE_NAME = "queue.task";
	private String name;
	
	public static void main(String[] argv) throws Exception {
		int worknum = 5;
		for(int i=1;i<=worknum;i++){
			Worker work = new Worker("工人"+i);
			work.startWork();
		}
	}
	public Worker() {
		
	}
	public Worker(String name){
		this.name=name;
	}
	
	private void startWork() throws IOException, TimeoutException{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(ServiceConstant.HOST_NAME);     factory.setPort(ServiceConstant.PORT);
		final Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println(this.name+"开始工作，等待接收工作");
		channel.basicQos(1);
		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				System.out.println(" [consumer] Received '" + message + "'");
				try {
					doWork(message);
				} finally {
					System.out.println(" [consumer] Done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}

	/**
	 * 模拟任务，字符中有1个.等待wait_unit_time 单位的ms时间
	 * 
	 * @param task
	 */
	private void doWork(String task) {
		long wait_unit_time = 1;
		int wait_times = 0;
		for (char ch : task.toCharArray()) {
			if (ch == '.') {
				wait_times++;
			}
		}
		long total_wait_time = wait_unit_time * wait_times;
		System.out.println(this.name+"任务执行任务开始，需要" + (wait_unit_time * wait_times / 1000) + "s,当前时间：" + System.currentTimeMillis());
		try {
			Thread.sleep(total_wait_time);
		} catch (InterruptedException _ignored) {
			Thread.currentThread().interrupt();
		}
		System.out.println(this.name+"任务执行结束，当前时间：" + System.currentTimeMillis());
	}
}
