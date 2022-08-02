package com.example.study.testDemo.rabbitMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


/**
 * 未找到例子
 *
 * 避免消息堆积？
 *     1） 采用workqueue，多个消费者监听同一队列。
 *     2）接收到消息以后，而是通过线程池，异步消费。
 *
 * 如何避免消息丢失？
 *      1） 消费者的ACK机制。可以防止消费者丢失消息。
 *          但是，如果在消费者消费之前，MQ就宕机了，消息就没了？
 *      2）可以将消息进行持久化。要将消息持久化，前提是：队列、Exchange都持久化
 * 原文链接：https://blog.csdn.net/kavito/article/details/91403659
 */

public class ConnectionUtil {
    /**
     * 建立与RabbitMQ的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/");//设置虚拟机，一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}