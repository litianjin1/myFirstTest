package com.example.study.testDemo.aspectDemo;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AspectInteface {

    public String title() default "";

    public boolean num() default false;

    public  String desc() default "无";
}
