package com.example.study.testDemo.aspectDemo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Aspect
@Component
public class AspectAnnotation {
    @Pointcut("execution(public * com.example.study.testDemo.controller.HelloWorldCntroller.*(..))")
    public void test(){
    }


    @Before("test()")
    public void beforeTest(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget().getClass();

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        System.out.println("signature.getDeclaringTypeName{}"+signature.getDeclaringTypeName());
        System.out.println("signature.getDeclaringType().getSimpleName{}"+signature.getDeclaringType().getSimpleName());

        Method method = methodSignature.getMethod();

        if(method != null){
            AspectInteface annotation = method.getAnnotation(AspectInteface.class);
            System.out.println("进入方法前 Start");
            System.out.println("标题1："+annotation.title());
            System.out.println("描述："+annotation.desc());
            System.out.println("进入方法前 End");

            try {
                Method reallyMethid = target.getClass().getMethod(methodSignature.getName(),methodSignature.getParameterTypes());
                reallyMethid.invoke(target.getClass().newInstance(),"与众不同的我,通过反射调用");
            } catch (NoSuchMethodException e) {
                System.out.println("未找到方法{}"+methodSignature.getName());
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        Object[] args = joinPoint.getArgs();
        for(Object o:args){
            System.out.println("切入参数："+o);
        }

    }

    @AfterReturning(value = "test()",returning = "res")
    public void afterTest(JoinPoint joinPoint,Object res) {


    }

    @Around("test()")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
