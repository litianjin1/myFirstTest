package com.example.study.mainTest;

import com.example.study.config.MainConfig;
import com.example.study.config.MainConfig2;
import com.example.study.facade.ColorFactoryBean;
import com.example.study.facade.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest2 {

    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        User user = (User) annotationConfigApplicationContext.getBean("user");
//        System.out.println(user);
        User hello2 = (User)annotationConfigApplicationContext.getBean("hello");
        User hello3 = (User)annotationConfigApplicationContext.getBean("hello");
        System.out.println(hello2 == hello3);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Object colorFactoryBean = annotationConfigApplicationContext.getBean("colorFactoryBean");
        //看似装载的是 colorFactoryBean ，内部实际上是 color
        System.out.println("获取的是ColorFactoryBean的内部bean类型，使用getObject："+colorFactoryBean.getClass());

        Object colorFactoryBean2 = annotationConfigApplicationContext.getBean("&colorFactoryBean");
        //看似装载的是 colorFactoryBean ，内部实际上是 color
        System.out.println("加入前缀 & ，可以获得ColorFactoryBean本身类型："+colorFactoryBean2.getClass());
    }


}
