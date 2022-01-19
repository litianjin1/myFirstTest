package com.example.study.testDemo.primaryDemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
//@Primary
public class Apple implements Fruit {
    @Override
    @PostConstruct
    public void init() {
        System.out.println("Apple PostConstruct 注解 ：开始");
    }

    @Override
    @PreDestroy
    public void destory() {
        System.out.println("Apple PreDestroy 注解 ：销毁");

    }

    @Override
    public void eat() {
        System.out.println("Apple ：吃苹果");

    }
}
