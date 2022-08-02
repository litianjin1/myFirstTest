package com.example.study.testDemo.rabbitMQ.workModel2;

import com.example.study.testDemo.rabbitMQ.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
//222工作队列或者竞争消费者模式
public class Send {
    private final static String QUEUE_NAME = "test_work_queue";

    /**
     * 可以发现，两个消费者各自消费了不同25条消息，这就实现了任务的分发。
     *          1、消费者1比消费者2的效率要低，一次任务的耗时较长
     *          2、 然而两人最终消费的消息数量是一样的
     *          3、消费者2大量时间处于空闲状态，消费者1一直忙碌
     *
     *
     *  解决方式：
     *      通过 BasicQos 方法设置 prefetchCount = 1。这样RabbitMQ就会使得每个Consumer在同一个时间点最多处理1个Message。换句话说，
     *      在接收到该Consumer的ack前，他它不会将新的Message分发给它。相反，它会将其分派给不是仍然忙碌的下一个Consumer。
     *      值得注意的是：prefetchCount在手动ack的情况下才生效，自动ack不生效。
     * 原文链接：https://blog.csdn.net/kavito/article/details/91403659
     * @param argv
     * @throws Exception
     */

    public static void main(String[] argv) throws Exception {
        // 获取到连接
        Connection connection = ConnectionUtil.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 循环发布任务
        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "task .. " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
 
            Thread.sleep(i * 2);
        }
        // 关闭通道和连接
        channel.close();
        connection.close();
    }
}