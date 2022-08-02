package com.example.study.testDemo.reflectionAndAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.example.study.testDemo.reflectionAndAnnotation.MyAnnotation.*;
import com.example.study.testDemo.reflectionAndAnnotation.MyAnnotation.MyClassAndMethodAnnotation.*;

@MyClassAnnotation(desc = "The Class 类型描述", uri = "包名地址：com.sgl.annotation ")
@MyClassAndMethodAnnotation(classType = EnumType.util)
public class TestAnnotation {
    @MyFieldAnnotation(desc = "The Class Field", uri = "com.sgl.annotation#id")
    private String id;

    public Integer num =0;

    @MyConstructorAnnotation(desc = "The Class Constructor", uri = "com.sgl.annotation#constructor")
    public TestAnnotation() {
    }


    public String getId() {
        return id;
    }

    @MyMethodAnnotation(desc = "The Class Method", uri = "com.sgl.annotation#setId")
    public void setId(String id) {
        this.id = id;
    }

    @MyMethodAnnotation(desc = "The Class Method sayHello", uri = "com.sgl.annotation#sayHello")
    public void sayHello(String name) {
        if (name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "\t:say hello world");
        }
    }

    public static void main(String[] args) throws Exception {
        Class c1 = TestAnnotation.class;

        Annotation[] annotations = c1.getAnnotations();
        //获取类上所有注解，根绝类型不同，转为不同注解对象，获取其中的属性值
        for (Annotation an:annotations){
            System.out.println(an);
            //先判断注解类型
            if(MyClassAnnotation.class == an.annotationType()){
                MyClassAnnotation myClassAnnotation = (MyClassAnnotation) an;
                System.out.println(myClassAnnotation.uri());
                System.out.println(myClassAnnotation.desc());
            }else if(MyClassAndMethodAnnotation.class == an.annotationType()){
                MyClassAndMethodAnnotation myClassAndMethodAnnotation = (MyClassAndMethodAnnotation) an;
                System.out.println(myClassAndMethodAnnotation.classType());
                System.out.println(myClassAndMethodAnnotation.color());
                System.out.println(myClassAndMethodAnnotation.arr());
            }
        }

        System.out.println("========================分割线 =========================");
        System.out.println(c1.getName());//com.example.study.testDemo.reflectionAndAnnotation.TestAnnotation
        System.out.println(c1.getSimpleName());//TestAnnotation
        System.out.println("getModifiers {}"+c1.getModifiers());
        System.out.println(" Modifier.toString {}"+ Modifier.toString(c1.getModifiers()));
        System.out.println("包信息："+c1.getPackage());
        System.out.println("父类信息："+c1.getSuperclass().getName());
        Class[] interfaces = c1.getInterfaces();
        for(Class it: interfaces){
            System.out.println("接口："+it.getName());
        }

        Constructor[] constructors = c1.getConstructors();
        for(Constructor con :constructors){
            TestAnnotation o = (TestAnnotation)con.newInstance();
            o.sayHello("hello");
            System.out.println("构造方法："+con.getName());
            Class[] parameterTypes = con.getParameterTypes();
            for (Class par :parameterTypes){
                System.out.println("构造参数类型："+par.getName());
            }
            //获取注解信息
            MyConstructorAnnotation myConstructorAnnotation = (MyConstructorAnnotation)con.getAnnotation(MyConstructorAnnotation.class);
            System.out.println(" 构造方法上的注解    ：   "+myConstructorAnnotation.desc()+" || "+myConstructorAnnotation.uri());
        }

        Method[] declaredMethods = c1.getDeclaredMethods();
        for(Method  m:declaredMethods){
            System.out.println("成员方法为："+m.getName());
        }

        Method sayHello = c1.getDeclaredMethod("sayHello",String.class);
        System.out.println("指定查找方法"+sayHello.getName());

        Class<?>[] types = sayHello.getParameterTypes();
        for(Class t:types){
            System.out.println("某个方法的参数："+t.getTypeName());
        }

        Class<?> returnType = sayHello.getReturnType();
        System.out.println("fanhui返回类型："+returnType.getTypeName());

        //获取示例: 类对象.neInstance
        TestAnnotation te = (TestAnnotation) c1.newInstance();
        sayHello.invoke(te,"苹果");
        //获取示例: 构造器.neInstance
        Constructor constructor = c1.getConstructor();
        TestAnnotation o = (TestAnnotation)constructor.newInstance();
        o.sayHello("构造器创建对象调用sayhello方法");
        sayHello.invoke(o,"反射调用这个方法");

        te.setId("goood");
        Field[] fields = c1.getFields();
        for (Field f:fields){
            f.set(te,100);
            System.out.println("成员变量"+f.getName()+":"+f.get(te));

        }

        Field[] declaredFields = c1.getDeclaredFields();
        for (Field ff:declaredFields){
            //调用私有属性需要调用setAccessible方法设置为true
            ff.setAccessible(false);
            System.out.println("私有变量"+ff.getName()+":"+ff.get(te));
            //
            MyFieldAnnotation myFieldAnnotation = (MyFieldAnnotation)ff.getAnnotation(MyFieldAnnotation.class);
            if(null != myFieldAnnotation){
                System.out.println(" 成员变量上的注解    ：   "+myFieldAnnotation.desc()+" || "+myFieldAnnotation.uri());

            }

        }
        Class<TestAnnotation> clazz = TestAnnotation.class;
        // 获取类注解
        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);
        System.out.println(myClassAnnotation.desc() + "+" + myClassAnnotation.uri());

        // 获得构造方法注解
        Constructor<TestAnnotation> constructors1 = clazz.getConstructor(new Class[] {});// 先获得构造方法对象
        MyConstructorAnnotation myConstructorAnnotation = constructors1.getAnnotation(MyConstructorAnnotation.class);// 拿到构造方法上面的注解实例
        System.out.println(myConstructorAnnotation.desc() + "+" + myConstructorAnnotation.uri());

        // 获得方法注解
        Method method = clazz.getMethod("setId", new Class[] { String.class });// 获得方法对象
        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
        System.out.println(myMethodAnnotation.desc() + "+" + myMethodAnnotation.uri());

        // 获得字段注解
        Field field = clazz.getDeclaredField("id");// 暴力获取private修饰的成员变量
        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
        System.out.println(myFieldAnnotation.desc() + "+" + myFieldAnnotation.uri());


    }
}