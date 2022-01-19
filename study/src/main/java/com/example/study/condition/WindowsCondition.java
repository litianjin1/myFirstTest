package com.example.study.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    /**
     *
     * @param conditionContext -- 判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata -- 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1、ioc使用的当前bean工厂
        ConfigurableListableBeanFactory factory = conditionContext.getBeanFactory();
        //2、类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、环境（运行时的环境变量，虚拟机变量）
        Environment environment = conditionContext.getEnvironment();
        //4、获取bean定义的注册类，可注册，可移除一个bean
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        System.out.println("environment.getProperty(\"os.name\") {}" + property);

        if(property.contains("Windows")){
            return  true;
        }
        return false;
    }
}
