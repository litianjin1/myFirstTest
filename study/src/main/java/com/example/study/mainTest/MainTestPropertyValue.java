package com.example.study.mainTest;

import com.example.study.config.MainConfig;
import com.example.study.config.MainConfigPropertyValue;
import com.example.study.facade.Car;
import com.example.study.facade.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.ArrayList;
import java.util.function.Supplier;

public class MainTestPropertyValue {

    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigPropertyValue.class);
        System.out.println("MainConfigPropertyValue 容器启动......");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

  /*      User user = (User) applicationContext.getBean("roleMapper");
        System.out.println("==============");
        System.out.println(user);*/

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("user.nickname");
        System.out.println(property);

        System.out.println("MainConfigPropertyValue 容器关闭......");
        applicationContext.close();
    }


    @Test
    public void test02(){

        ArrayList<Object> objects = new ArrayList<>();
        String s = "你好世界";
        System.out.println(s.contains("好"));
        System.out.println(s.contains("kk"));
    }

}
