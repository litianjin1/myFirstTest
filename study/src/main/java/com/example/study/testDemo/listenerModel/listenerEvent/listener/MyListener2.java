package com.example.study.testDemo.listenerModel.listenerEvent.listener;

import com.example.study.testDemo.listenerModel.listenerEvent.event.MyEvent2;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 监听者，必须实现ApplicationListener，并指定泛型为我们的自定义事件
 */
@Log4j2
@Component
public class MyListener2{

/*    @Async
    @EventListener(MyEvent2.class)
    public void onApplicationEvent(MyEvent2 event) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("springboot注解版事件监听，111监听器收到信息："+event.getMsg());
    }*/
    @EventListener(MyEvent2.class)
    public void onApplicationEvent2(MyEvent2 event) {
        log.info("springboot注解版事件监听，2222监听器收到信息："+event.getMsg());
    }
}
