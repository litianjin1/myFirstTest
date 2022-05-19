//package com.example.study.testDemo.kafkaDemo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@Transactional
//@RestController
//public class KafkaProducer {
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    //================== 简单生产者 Start =====================
//    // 发送消息
//    @GetMapping("/kafka/normal/{message}")
//    public String sendMessage1(@PathVariable("message") String normalMessage) {
//        kafkaTemplate.send("topic1",normalMessage);
//        return "发送成功";
//    }
//    //================== 简单生产者 End ======================
//
//
//
////=========================================== 带回调的生产者 start ================================================
//    /**
//     *  kafkaTemplate提供了一个回调方法addCallback，我们可以在回调方法中监控消息是否发送成功 或 失败时做补偿处理，有两种写法
//     *  第一种
//     */
//    @GetMapping("/kafka/callbackOne/{message}")
//    public String sendMessage2(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic1", callbackMessage).addCallback(success -> {
//            // 消息发送到的topic
//            String topic = success.getRecordMetadata().topic();
//            // 消息发送到的分区
//            int partition = success.getRecordMetadata().partition();
//            // 消息在分区内的offset
//            long offset = success.getRecordMetadata().offset();
//            String value = (String) success.getProducerRecord().value();
//            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset +"---"+callbackMessage);
//        }, failure -> {
//            System.out.println("发送消息失败:" + failure.getMessage()  +"---"+callbackMessage);
//        });
//        return "callbackOne发送---"+callbackMessage;
//    }
//
//    /** 第二种  */
//    @GetMapping("/kafka/callbackTwo/{message}")
//    public String sendMessage3(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic1", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("发送消息失败："+ex.getMessage()+" --- "+callbackMessage);
//            }
//            @Override
//            public void onSuccess(SendResult<String, Object> result) {
//                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
//                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset() +" --- "+callbackMessage);
//            }
//        });
//        return "callbackTwo 发送---"+callbackMessage;
//    }
////=========================================== 带回调的生产者 End ================================================
//
//
//// ===========================  kafka事务提交 Start ===========================================================
//    /**
//     * 如果在发送消息时需要创建事务，可以使用 KafkaTemplate 的 executeInTransaction 方法来声明事务，
//     */
//    @GetMapping("/kafka/transaction")
//    public void sendMessage7(){
//        // 声明事务：后面报错消息不会发出去
//        kafkaTemplate.executeInTransaction(operations -> {
//            operations.send("topic1","executeInTransaction test executeInTransaction");
//            throw new RuntimeException("fail1111");
//         });
//         // 不声明事务：后面报错但前面消息已经发送成功了
//        kafkaTemplate.send("topic1","NORMAL test executeInTransaction");
//        throw new RuntimeException("fail2222");
//    }
//// ===========================  kafka事务提交 End ===========================================================
//
//}