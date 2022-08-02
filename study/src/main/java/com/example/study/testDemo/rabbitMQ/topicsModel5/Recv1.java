package com.example.study.testDemo.rabbitMQ.topicsModel5;

import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv1 {
    private final static String QUEUE_NAME = "topic_exchange_queue_Q1";
    private final static String EXCHANGE_NAME = "test_topic_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //3333 避免消息丢失要将 消息，交换机，队列都持久化，此处是队列 持久化   durable : true
//        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 绑定队列到交换机，同时指定需要订阅的routing key。订阅所有的橙色动物
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.orange.*");
 
        // 定义队列的消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                // body 即消息体
                String msg = new String(body);
                System.out.println(" [消费者1] received : " + msg + "!");
            }
        };
        // 监听队列，自动ACK
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}