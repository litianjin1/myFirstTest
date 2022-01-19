package com.example.study.testDemo.threadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {
    private static AtomicInteger list = new AtomicInteger(0);

    public static void main(String[] args) {

//        new ThreadPoolExecutor();
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println(i1);

        int num = 999999999;
        System.out.println("num:"+num);

        Integer numDD = new Integer("99");
        System.out.println("numDD:"+numDD);

        num =numDD;
        System.out.println("num:"+num);

        numDD = 1;
        System.out.println("numDD:"+numDD);

//        Demo2 demo =new Demo2();
//        new Thread(()->{
//            for (int i=1;i<=10000;i++){
//                list.set(list.addAndGet(i));
//                System.out.print(Thread.currentThread().getName()+":");
//                System.out.println(demo.list);
//            }
//
//        }).start();
//
//        new Thread(()->{
//            for (int i=1;i<=10000;i++){
//                list.set(list.addAndGet(i));
//                System.out.print(Thread.currentThread().getName()+":");
//                System.out.println(demo.list);
//            }
//        }).start();
    }
}
