package com.example.study.facade;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    private String name;
    private Double price;
    private Integer size;

    public Car(){
        System.out.println("Car .... constructor.....");
    }

    public Car(String name, Double price, Integer size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    //销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Car ..... destroy ......销毁方法");
    }

    // 创建并赋值以后执行
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car ..... afterPropertiesSet ......创建并赋值以后执行");

    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
