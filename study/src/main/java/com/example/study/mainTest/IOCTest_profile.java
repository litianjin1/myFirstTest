package com.example.study.mainTest;

import com.example.study.config.MainConfig;
import com.example.study.config.MainConfigProfile;
import com.example.study.facade.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_profile {

    @SuppressWarnings("resource")
    /**
     * 1、使用命令行参数，在虚拟机参数位置加载激活使用 （-Dspring.profiles.active=test）
     *
     * 2、使用代码方式，以下四步操作代码。
     */
    @Test
    public void test01(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、创建一个无参的applicationContext
        //2、设置激活环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        //3、 注册主配置类
        applicationContext.register(MainConfigProfile.class);
        //4\启动刷新容器
        applicationContext.refresh();

        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println("数据源有："+s);
        }

        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
        applicationContext.close();
    }


}
