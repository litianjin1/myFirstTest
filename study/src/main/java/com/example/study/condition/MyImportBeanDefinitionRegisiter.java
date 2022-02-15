package com.example.study.condition;

import com.example.study.facade.UserVO;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegisiter implements ImportBeanDefinitionRegistrar {

    /**
     * 可以自定义注册bean信息
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean roleVO = registry.containsBeanDefinition("com.example.study.facade.RoleVO");
        if(roleVO){
            //指定bean的定义信息
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(UserVO.class);
            //注册一个bean
            registry.registerBeanDefinition("userVO",rootBeanDefinition);
        }
    }
}
