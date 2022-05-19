package com.example.study.testDemo.lambdaDemo.testJava18;

public interface TestDefaultMethod {

    default void eat(){
        System.out.println("默认吃东西了。。。。。");
    }
    default void play(){
        System.out.println("默认完球了。。。。");
    }

    void run();

    void action();
}
