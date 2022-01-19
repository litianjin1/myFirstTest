package com.example.study.config;


import com.example.study.condition.WindowsCondition;
import com.example.study.facade.User;
import org.springframework.context.annotation.*;

/**
 * 导入组件的方式 1、扫描包路径，扫描标注解 @Controller，@Component,@service,@repository
 *  2、配置类里使用@bean ，到第三方包内的类
 *  3、@import(快素给容器导入一个组件)
 *     1）@Import(要导入的组件)
 *     2）ImportSelector 接口： 返回需要导入的组件的全类名数组
 *     3)ImportBeanDefinitionRegistrar 接口：手动注册bean到容器中
*   4、使用 spring 的 FactoryBean (工厂bean)
 *          1）、默认获得的工厂bean调用getObject创建的对象
 *          2)、要想获得工厂bean本身，我们需要给id前面加上 前缀 & ，例如 ：&colorFactoryBean
 *
 */
@Configuration
@ComponentScan(value = "com.example.study")
public class MainConfig {

    @Conditional({WindowsCondition.class})
    @Lazy
    @Scope("singleton")
//    @Scope("prototype")
    @Bean("hello")
    public User user(){
        return new User("user_name","user_id");
    }
}
