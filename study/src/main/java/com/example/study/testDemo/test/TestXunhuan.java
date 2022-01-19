package com.example.study.testDemo.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 循环依赖及其解决方式
 */
@Configuration

@ComponentScan(basePackages = {"com.example.study.testDemo.test.beans"})
public class TestXunhuan {
    public static void main(String[] args) {
       Integer anum = 1000;
       Integer b = -1100;

        int i = anum + b;

        System.out.println(i<0?0:i);

    }
}
