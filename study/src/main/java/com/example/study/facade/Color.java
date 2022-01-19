package com.example.study.facade;

public class Color {

    public Color(){
        System.out.println("调用Color 构造器,创建");
    }

    public void init(){
        System.out.println("初始化color");
    }

    public void destory(){
        System.out.println("销毁color");
    }
}
