package com.example.study.testDemo.page1;

import com.example.study.testDemo.page1.StaticClass;

public class TestStatic {
    //　　1、当外部内静态变量被调用

/*    public static void main(String[] args) {
        StaticClass instance = StaticClass.getInstance();
        System.out.println(instance.toString());
        System.out.println(instance.getSstr());
        StaticClass outer = new StaticClass();
        System.out.println("外部类静态变量加载时间：" + outer.OUTER_DATE);
    }*/

//    　2、非静态内部类变量调用时：

/*    public static void main(String[] args) {
        StaticClass outer = new StaticClass();
        System.out.println("非静态内部类加载时间"+outer.new InnerClass().INNER_DATE);
    }*/

//3、静态内部类中的变量被调用时：

    public static void main(String[] args) {
        System.out.println("静态内部类加载时间：" + StaticClass.InnerStaticClass.INNER_STATIC_DATE);
    }
}
