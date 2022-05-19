package com.example.study.testDemo.listenerModel.listenerEvent.publish;

import com.example.study.testDemo.listenerModel.listenerEvent.event.MyEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 发布者，直接用我们的上下文对象进行发布，它继承了ApplicationEventPublisher
 */
@EnableAsync
@Component
@SpringBootTest
public class MyPublish {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public  void publish() {
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class) ;

        applicationContext.publishEvent(new MyEvent(this,"第"+99+"次， 你啊飒飒好啊啊！！！"));
        applicationContext.publishEvent(new MyEvent(this,"你好世界！！！"));
    }

}
