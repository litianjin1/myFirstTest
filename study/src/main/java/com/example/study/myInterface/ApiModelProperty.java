package com.example.study.myInterface;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelProperty {
    String value() default "";
    String example() default "";
    boolean required() default false;
//    String description() default "";
}
