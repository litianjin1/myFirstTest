package com.example.study.testDemo.listenerModel.listenerEvent;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

@Component
public class AsyncEventMulticaster extends SimpleApplicationEventMulticaster {

    public AsyncEventMulticaster(){
        System.out.println("设置广播器的TaskExecutor>>>>>>>>>>>>>>>>>>>>>");
        setTaskExecutor(Executors.newFixedThreadPool(3));
    }
}
