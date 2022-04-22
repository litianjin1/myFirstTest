package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class StudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StudyApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
   /*     for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println("=============================================================");
            System.out.println(beanDefinitionName);
        }*/
    }


}
