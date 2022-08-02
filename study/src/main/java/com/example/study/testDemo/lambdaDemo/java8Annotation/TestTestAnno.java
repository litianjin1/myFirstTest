package com.example.study.testDemo.lambdaDemo.java8Annotation;



import org.testng.annotations.Test;

import java.lang.annotation.Annotation;

public class TestTestAnno {

    @MyRepeatInteface("hello")
    @MyRepeatInteface("world")
    class AnnoInner{

    }

    @Test
    public void test01(){
        Class<AnnoInner> annoInnerClass = AnnoInner.class;
        MyRepeatInteface[] annotation = annoInnerClass.getAnnotationsByType(MyRepeatInteface.class);
        annotation[0].value();

//        MyRepeatInteface annotation = AnnoInner.class.getAnnotation(MyRepeatInteface.class);

        System.out.println(annotation[0].value() + " "+annotation[1].value());
    }
}
