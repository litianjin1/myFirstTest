package com.example.study.facade;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    public Cat(){
        System.out.println("Cat .... constructor.....");
    }
    public void init(){
        System.out.println("初始化color");
    }

    public void destory(){
        System.out.println("销毁color");
    }
}
