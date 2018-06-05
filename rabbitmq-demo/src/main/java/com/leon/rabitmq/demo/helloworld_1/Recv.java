package com.leon.rabitmq.demo.helloworld_1;
import com.rabbitmq.client.*;

/**
 * 模拟消费者，信道声明的为一个queue,一条信息只能由一个其中连接着获取到
 */
import java.io.IOException;
public class Recv {

  private final static String QUEUE_NAME = "QUEUE_HELLOWORLD";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
        try {
			Thread.sleep(100);
//			channel.basicAck(envelope.getDeliveryTag(), true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    };
    channel.basicConsume(QUEUE_NAME, true, consumer);  //参数二指定自动确认信息
  }
}