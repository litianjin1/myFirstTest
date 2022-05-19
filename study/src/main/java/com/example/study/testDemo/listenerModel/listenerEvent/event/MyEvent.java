package com.example.study.testDemo.listenerModel.listenerEvent.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件类，必须实现 ApplicationEvent
 */
public class MyEvent extends ApplicationEvent
{

    private String msg;
    public MyEvent(Object source ,String msg) {
        super(source);
        this.msg= msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
