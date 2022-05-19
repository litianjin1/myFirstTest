package com.example.study.testDemo.listenerModel.listenerEvent.listener;

import com.example.study.testDemo.listenerModel.listenerEvent.event.MyEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 监听者，必须实现ApplicationListener，并指定泛型为我们的自定义事件
 */
@Component
@Log4j2
public class MyListener implements ApplicationListener<MyEvent> {
    @Async
    @Override
    public void onApplicationEvent(MyEvent event) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("监听器收到信息："+event.getMsg());
        log.info("监听器收到信息："+event.getMsg());
    }
}
