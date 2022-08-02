package com.example.study.testDemo.rabbitMQ.topicsModel5;

import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

/**
 * 555 Topics 通配符模式（交换机类型：topics）
 *
 * 每个消费者监听自己的队列，并且设置带统配符的routingkey,生产者将消息发给broker，由交换机根据routingkey来转发消息到指定的队列。
 * Routingkey一般都是有一个或者多个单词组成，多个单词之间以“.”分割，例如：inform.sms
 * 通配符规则：
 *          #：匹配一个或多个词
 *          *：匹配不多不少恰好1个词
 *
 *          举例：
 *              audit.#：能够匹配audit.irs.corporate 或者 audit.irs
 *              audit.*：只能匹配audit.irs
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_topic_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为topic
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        //1111 避免消息丢失要将 消息，交换机，队列都持久化，此处是交换机持久化   durable : true
        // channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC,true);
        // 消息内容
        String message = "这是一只行动迅速的橙色的兔子";
        String message2 = "这是一只懒惰的乌龟";
        // 发送消息，并且指定routing key为：quick.orange.rabbit
        channel.basicPublish(EXCHANGE_NAME, "quick.orange.rabbit", null, message.getBytes());

        //2222 避免消息丢失要将 消息，交换机，队列都持久化，此处是消息持久化   durable : true
//        channel.basicPublish(EXCHANGE_NAME, "lazy.pink.rabbitqq", MessageProperties.PERSISTENT_TEXT_PLAIN, message2.getBytes());
        System.out.println(" [动物描述：] Sent '" + message + "'");
        System.out.println(" [动物描述：] Sent '" + message2 + "'");

        channel.close();
        connection.close();
    }
}