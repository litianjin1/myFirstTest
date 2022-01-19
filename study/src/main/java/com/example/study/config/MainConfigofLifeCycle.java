package com.example.study.config;

import com.example.study.facade.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期，
 *      bean创建 ===  初始胡 === 销毁
 *
 * 容器管理bean 的生命周期，
 *       自定义初始化和销毁方法
 * 创建：
 *      单实例：在容器启动时创建对象；
 *      多实例：每次回去对象时，才创建
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
*    销毁：
 *          单实例：容器关闭时，调用
 *          多实例：容器不会管理这个bean,容器不会调用销毁方法。
 *
 *
 *  1）、指定初始化和销毁方法  ：
 *        通过@Bean(initMethod ="init",destroyMethod = "destory")
 *  2）、通过让bean实现initializingBean (定义初始化逻辑)
 *                             DisposableBean（定义销毁逻辑）
 *   3)、使用JSR250 的注解，java规范
 *                  @PostConstructor 标在需要初始化的方法上
 *                  @PreDestory  标在需要执行的销毁方法上
 *  4）、自定义实现接口 BeanPostProcessor，在初始化方法前后，可以进行拦截
 *          postProcessBeforeInitialization ：在初始化方法之前调用
 *          postProcessAfterInitialization ： 在初始化方法执行之后，才调用
 */
@ComponentScan("com.example.study")
@Configuration
public class MainConfigofLifeCycle {

    @Bean(initMethod ="init",destroyMethod = "destory")
    public Color color(){
        return new Color();
    }

}
