package com.example.study.testDemo.primaryDemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pear implements Fruit{
    @Override
    @PostConstruct
    public void init() {
        System.out.println("Pear PostConstruct 注解 ：开始");
    }

    @Override
    @PreDestroy
    public void destory() {
        System.out.println("Pear PreDestroy 注解 ：销毁");

    }

    @Override
    public void eat() {
        System.out.println("Pear ：吃梨子");

    }
}
