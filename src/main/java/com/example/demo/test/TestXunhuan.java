package com.example.demo.test;

import com.example.demo.test.beans.BeanA;
import com.example.demo.test.beans.BeanB;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 循环依赖及其解决方式
 */
@Configuration

@ComponentScan(basePackages = { "com.example.demo.test.beans" })
public class TestXunhuan {
    public static void main(String[] args) {
        BeanA beanA = new BeanA();
        BeanB b = beanA.b;

    }
}
