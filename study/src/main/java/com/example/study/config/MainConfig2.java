package com.example.study.config;

import com.example.study.condition.MyImportBeanDefinitionRegisiter;
import com.example.study.condition.MyImportSelector;
import com.example.study.facade.ColorFactoryBean;
import com.example.study.facade.MenuVO;
import com.example.study.facade.RoleVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

//@Configuration
//@ComponentScan(value = "com.example.study")
//@Import({MenuVO.class, RoleVO.class, MyImportSelector.class, MyImportBeanDefinitionRegisiter.class})
//@EnableAsync
public class MainConfig2 {

//    @Lazy
//    @Scope("singleton")
 /*   @Bean("hello2")
    public User user(){
        return new User("user_name","user_id");
    }*/

    //使用spring的 FactoryBean, 实际内部返回的bean是 Color对象。
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}