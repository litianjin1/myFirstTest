package com.example.study.testDemo.rabbitMQ.routingModel4;

import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 444 Routing 路由模型（交换机类型：direct）
 *  P：生产者，向Exchange发送消息，发送消息时，会指定一个routing key。
 *  X：Exchange（交换机），接收生产者的消息，然后把消息递交给 与routing key完全匹配的队列
 *  C1：消费者，其所在队列指定了需要routing key 为 error 的消息
 *  C2：消费者，其所在队列指定了需要routing key 为 info、error、warning 的消息
 * 原文链接：https://blog.csdn.net/kavito/article/details/91403659
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_direct_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为direct
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 消息内容，
//        String message = "注册成功！请短信回复[T]退订";
        String message = "注册成功！请邮件回复[T]退订";
        // 发送消息，并且指定routing key 为：sms，只有短信服务能接收到消息
        channel.basicPublish(EXCHANGE_NAME, "email", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
 
        channel.close();
        connection.close();
    }
}