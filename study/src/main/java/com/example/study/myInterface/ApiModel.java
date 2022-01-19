package com.example.study.myInterface;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModel {
    String value() default "";
    String description() default "";
}
