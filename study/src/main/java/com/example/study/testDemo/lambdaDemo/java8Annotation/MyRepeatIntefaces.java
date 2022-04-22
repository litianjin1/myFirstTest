package com.example.study.testDemo.lambdaDemo.java8Annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyRepeatIntefaces {

    MyRepeatInteface[] value();
}
