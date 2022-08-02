package com.example.study.testDemo.rabbitMQ.rpcModel6;

import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.testng.annotations.Test;

/**
 * 666 RPC 模型（交换机类型：rpc）
 *
 基本概念：
     Callback queue 回调队列，客户端向服务器发送请求，服务器端处理请求后，将其处理结果保存在一个存储体中。而客户端为了获得处理结果，那么客户在向服务器发送请求时，同时发送一个回调队列地址reply_to。
     Correlation id 关联标识，客户端可能会发送多个请求给服务器，当服务器处理完后，客户端无法辨别在回调队列中的响应具体和那个请求时对应的。为了处理这种情况，客户端在发送每个请求时，同时会附带一个独有correlation_id属性，这样客户端在回调队列中根据correlation_id字段的值就可以分辨此响应属于哪个请求。
 流程说明：
     当客户端启动的时候，它创建一个匿名独享的回调队列。
     在 RPC 请求中，客户端发送带有两个属性的消息：一个是设置回调队列的 reply_to 属性，另一个是设置唯一值的 correlation_id 属性。
     将请求发送到一个 rpc_queue 队列中。
     服务器等待请求发送到这个队列中来。当请求出现的时候，它执行他的工作并且将带有执行结果的消息发送给 reply_to 字段指定的队列。
     客户端等待回调队列里的数据。当有消息出现的时候，它会检查 correlation_id 属性。如果此属性的值与请求匹配，将它返回给应用
 原文链接：https://blog.csdn.net/kavito/article/details/91403659
 */
public class Send {
    private final static String EXCHANGE_NAME = "test_rpc_exchange";
 
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

    @Test
    public void test01(){
        StringBuilder sb = new StringBuilder("你好李天");
        sb = sb.delete(2, (sb.length() - 2));
        sb.insert(2,"****");
        System.out.println(sb.toString());
    }
}