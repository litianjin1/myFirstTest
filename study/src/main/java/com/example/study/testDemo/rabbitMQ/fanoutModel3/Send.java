package com.example.study.testDemo.rabbitMQ.fanoutModel3;


import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


/**
 * Exchange类型有以下几种：
     * Fanout：广播，将消息交给所有绑定到交换机的队列
     * Direct：定向，把消息交给符合指定routing key 的队列
     * Topic：通配符，把消息交给符合routing pattern（路由模式） 的队列
     * Header：header模式与routing不同的地方在于，header模式取消routingkey，使用header中的 key/value（键值对）匹配队列。
 * Header模式不展开了，感兴趣可以参考这篇文章https://blog.csdn.net/zhu_tianwei/article/details/40923131
 */

/**
 * 和前面两种模式不同：
 * 1） 声明Exchange，不再声明Queue
 * 2） 发送消息到Exchange，不再发送到Queue
 */
public class Send {
 
    private final static String EXCHANGE_NAME = "test_fanout_exchange";
 
    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明exchange，指定类型为fanout
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        
        // 消息内容
        String message = "注册成功！！";
        // 发布消息到Exchange
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [生产者] Sent '" + message + "'");
 
        channel.close();
        connection.close();
    }
}