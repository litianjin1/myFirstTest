package com.example.study.testDemo.primaryDemo;

public interface Fruit {

    //@PostConstruct  初始化的调用
    public void init();
    // @PreDestory  销毁时的调用
    public void destory();

    //
    public void eat();
}
