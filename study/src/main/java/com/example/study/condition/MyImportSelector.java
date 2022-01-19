package com.example.study.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//第三种导入组件的方式
//自定义需要导入的组件
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值 是 导入到IOC容器中的组件全类名
     * @param annotationMetadata :当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.example.study.facade.Student"};
    }
}
