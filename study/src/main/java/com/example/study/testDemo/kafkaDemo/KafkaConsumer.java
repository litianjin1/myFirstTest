package com.example.study.testDemo.kafkaDemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {
    // ============== 简单消费者 !!!! 如果不显示，可以多发几条就会出现了，不知道为何===============
    // 消费监听
    @KafkaListener(topics = {"topic1"})
    @SendTo("testtopic")
    public String  onMessage1(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("topic1简单消费："+record.topic()+"-"+record.partition()+"-"+record.offset()+"-"+record.value());
        return  "转发消息：{}"+record.value();
    }

    @KafkaListener(topics = {"testtopic"})
    public void onMessage11(String record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("testtopic消费："+record);
    }
    // ============================================= 简单消费者 End=============== ===================================

    /**
     * @Title 指定topic、partition、offset消费
     * @Description 同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
     * @Author long.yuan
     * @Date 2020/3/22 13:38
     * @Param [record]
     * @return void
     **/
/*    @KafkaListener(id = "consumer1",groupId = "ConsumerGroup_test",topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = { "0" }),
            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
    })
    public void onMessage2(ConsumerRecord<?, ?> record) {
        System.out.println("指定topic、partition、offset消费 :topic:"+record.topic()
                +"|partition:"+record.partition()
                +"|offset:"+record.offset()
                +"|key:"+record.key()+
                "|value:"+record.value());
    }*/


    /**
     * 接收消息时用List来接收
     * # 设置批量消费
     * spring.kafka.listener.type=batch
     * # 批量消费每次最多消费多少条消息
     * spring.kafka.consumer.max-poll-records=50
     *
     *
     * ！！！！报错：org.springframework.core.convert.ConverterNotFoundException: No converter found capable of converting from
     *              type [java.lang.String] to type [org.apache.kafka.clients.consumer.ConsumerRecord<?, ?>]
     *      这种情况，因为开启了批量消费，所以首先要排除掉代码中单个消费的监听，这个报错不是批量消费爆出的错，是监听开启批量后，单个消费报的错。
     * @param records
     */
/*    @KafkaListener(id = "consumer2",groupId = "defaultConsumerGroup", topics = "topic1")
    public void onMessage3(List<ConsumerRecord<?, ?>> records) {
        System.out.println(">>>批量消费一次，records.size()="+records.size());
        for (ConsumerRecord<?, ?> record : records) {
            System.out.println(record.value());
        }
    }*/

//========================================  消费异常处理 Start ================================================================
    /**
     * 通过异常处理器，我们可以处理consumer在消费时发生的异常。
     *
     * 新建一个 ConsumerAwareListenerErrorHandler 类型的异常处理方法，用@Bean注入，BeanName默认就是方法名，
     * 然后我们将这个异常处理器的BeanName放到@KafkaListener注解的errorHandler属性里面，
     * 当监听抛出异常的时候，则会自动调用异常处理器，
     * @return
     */
    // 新建一个异常处理器，用@Bean注入
    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常："+message.getPayload());
            return null;
        };
    }

// 将这个异常处理器的BeanName放到@KafkaListener注解的errorHandler属性里面

/*    @KafkaListener(topics = {"topic1"},errorHandler = "consumerAwareErrorHandler")
    public void onMessage4(ConsumerRecord<?, ?> record) throws Exception {
//        throw new Exception("简单消费-模拟异常");
    }

    // 批量消费也一样，异常处理器的message.getPayload()也可以拿到各条消息的信息
    @KafkaListener(topics = "topic1",errorHandler="consumerAwareErrorHandler")
    public void onMessage5(List<ConsumerRecord<?, ?>> records) throws Exception {
        System.out.println("批量消费一次...");
//        throw new Exception("批量消费-模拟异常");
    }*/
//========================================  消费异常处理 End ================================================================




//========================================  消息过滤器 Start ================================================================
    @Autowired
    private  ConsumerFactory consumerFactory;
    /**
     * 消息过滤器可以在消息抵达consumer之前被拦截，在实际应用中，我们可以根据自己的业务逻辑，
     * 筛选出需要的信息再交由KafkaListener处理，不需要的消息则过滤掉。
     *
     * 配置消息过滤只需要为 监听器工厂 配置一个RecordFilterStrategy（消息过滤策略），返回true的时候消息将会被抛弃，返回false时，消息能正常抵达监听容器。
     * 示例：过滤奇数、接收偶数
     * @return
     */
    // 消息过滤器
/*    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            Integer num = null;
            try {
                num = Integer.parseInt(consumerRecord.value().toString());
            } catch (NumberFormatException e) {
                num = 1;
            }

            if (num % 2 == 0) {
                return false;
            }
            //返回true消息则被过滤
            return true;
        });
        return factory;
    }*/
    // 消息过滤监听
/*    @KafkaListener(topics = {"topic1"},containerFactory = "filterContainerFactory")
    @SendTo("testtopic")
    public void onMessage6(ConsumerRecord<?, ?> record) {
        System.out.println("消息过滤监听,只显示偶数:"+record);
    }*/
//========================================  消息过滤器 End ================================================================



//========================================  消息转发 Start ================================================================
    /**
     * 在实际开发中，我们可能有这样的需求，应用A从TopicA获取到消息，经过处理后转发到TopicB，再由应用B监听处理消息，
     * 即一个应用处理完成后将该消息转发至其他应用，完成消息的转发。
     * 在SpringBoot集成Kafka实现消息的转发也很简单，
     * !!!!!! 只需要通过一个@SendTo注解，被注解方法的return值即转发的消息内容，如下
     */
    /**
     * @Title 消息转发
     * @Description 从topic1接收到的消息经过处理后转发到topic2
     * @Author long.yuan
     * @Date 2020/3/23 22:15
     * @Param [record]
     * @return void
     **/
/*    @KafkaListener(topics = {"topic1"})
    @SendTo("topic2")
    public String onMessage7(ConsumerRecord<?, ?> record) {
        return record.value()+"-forward message";
    }*/

//========================================  消息转发 End ================================================================



//========================================  消息转发 Start ================================================================

//========================================  消息转发 End ================================================================

}