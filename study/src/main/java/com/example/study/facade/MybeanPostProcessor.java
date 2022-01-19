package com.example.study.facade;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MybeanPostProcessor implements BeanPostProcessor {

    //在初始化方法之前调用
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessBeforeInitialization....bean名称:  "+beanName);
        return bean;
    }

    //在初始化方法执行之后，才调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization....bean名称:   "+beanName);

        return bean;
    }
}
