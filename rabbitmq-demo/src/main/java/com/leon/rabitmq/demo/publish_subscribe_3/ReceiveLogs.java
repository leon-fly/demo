package com.leon.rabitmq.demo.publish_subscribe_3;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
/**
 * 声明的为fanout类型的exchange，几个队列绑定就有几个队列获取到发送的信息，不使用路由键匹配
 * @author leonwang
 *
 */
public class ReceiveLogs {
  private static final String EXCHANGE_NAME = "logs";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    channel.exchangeDeclare(EXCHANGE_NAME, "fanout",true,true,null); //声明一个交换组件
    String queueName = channel.queueDeclare().getQueue();  //获得一个队列
    channel.queueBind(queueName, EXCHANGE_NAME, "");  //将队列绑定到交换组件上，不使用路由键匹配
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope,
                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(queueName, true, consumer);
  }
}
