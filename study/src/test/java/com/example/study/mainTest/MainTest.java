package com.example.study.mainTest;

import com.example.study.config.MainConfig;
import com.example.study.facade.User;
import com.example.study.service.impl.RoleServiceExtendImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        User user = (User) annotationConfigApplicationContext.getBean("user");
//        System.out.println(user);
//        RoleServiceExtendImpl hello = (RoleServiceExtendImpl)annotationConfigApplicationContext.getBean(RoleServiceExtendImpl.class);
//        hello.goodDefault();
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        annotationConfigApplicationContext.close();
    }


}
