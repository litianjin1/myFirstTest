package com.example.study.config;

import com.example.study.facade.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:pro.properties"})
@Configuration
@MapperScan("com.example.study.mapper")
public class MainConfigPropertyValue {

    @Bean
    public User user(){
        return new User();
    }
}
