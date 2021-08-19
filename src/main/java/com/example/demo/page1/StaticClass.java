package com.example.demo.page1;

import org.springframework.stereotype.Component;

//测试静态内部类
@Component
public class StaticClass {

    public static long OUTER_DATE = System.currentTimeMillis();
    public  String sstr ="ssss";
    static {
        System.out.println("外部类静态块加载时间：" + System.currentTimeMillis());
    }

    public StaticClass() {
        System.out.println("外部类构造函数时间：" + System.currentTimeMillis());
    }

    static class InnerStaticClass {
        private static final StaticClass cmd =new StaticClass();
        public static long INNER_STATIC_DATE = System.currentTimeMillis();
        static{
            System.out.println("静态内部类静态块加载时间：" + System.currentTimeMillis());
        }
    }
    public static StaticClass getInstance() {
        return InnerStaticClass.cmd;
    }

    class InnerClass {
        public long INNER_DATE = 0;
        public InnerClass() {
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public String getSstr() {
        return sstr;
    }

    public void setSstr(String sstr) {
        this.sstr = sstr;
    }
}