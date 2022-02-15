package com.example.study.mainTest;

import com.example.study.config.MainConfig;
import com.example.study.facade.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeasXmlTest {

    @SuppressWarnings("resource")
    @Test
    public void test01(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        User user = (User) applicationContext.getBean("user");
//        System.out.println(user.getAge());
//        System.out.println(user.getName());
//        ((ClassPathXmlApplicationContext) applicationContext).close();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }


}
