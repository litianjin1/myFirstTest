package com.example.study.mainTest;

import com.example.study.config.MainConfigofLifeCycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigofLifeCycle.class);
        System.out.println("容器启动了");

        //容器销毁
        annotationConfigApplicationContext.close();
    }
}
