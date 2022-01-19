package com.example.study.facade;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    //是否为单实例 ，为ture时，单实例
    @Override
    public boolean isSingleton() {
        return false;
    }

    //返回对象
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    //返回类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
