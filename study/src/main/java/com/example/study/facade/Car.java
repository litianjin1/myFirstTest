package com.example.study.facade;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Car implements InitializingBean, DisposableBean {

    public Car(){
        System.out.println("Car .... constructor.....");
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
}
