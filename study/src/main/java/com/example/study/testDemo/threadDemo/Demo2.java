package com.example.study.testDemo.threadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public  class Demo2 {

    private static volatile Boolean flag = false;

    public static void main(String[] args) {
//        test01();
//        test02();
        Demo2 demo2 = new Demo2();
        demo2.test03();
    }

    //join
    public static void test01(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for(int y =1 ;y<=6;y++){
                    System.out.println("开始学习"+y+"年！");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(y==4){
                        System.out.println("学有所成毕业了！！");
                        break;
                    }
                }
            }
        };
        Thread threadA = new Thread(runnable);

        Thread threadB = new Thread(() -> {
            try {
                threadA.join();
                System.out.println("开始找工作了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadB.start();
        threadA.start();

    }

    //volatila
    public static void test02(){

        Thread threadA = new Thread(()->{
            while (true){
                if(!flag){
                    for(int y =1 ;y<=6;y++){
                        System.out.println("开始学习"+y+"年！");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(y==4){
                            System.out.println("学有所成毕业了！！");
                            flag = true;
                            break;
                        }
                    }
                    break;
                }
            }

        });

        Thread threadB = new Thread(() -> {
            while (true){
                if(flag){
                    System.out.println("开始找工作了");
                    break;
                }
            }

        });

        threadB.start();
        threadA.start();

    }

    //synchronized   notify  wait
    public void test03(){

        Thread threadA = new Thread(()->{

            synchronized (this){
                for(int y =1 ;y<=6;y++){
                    System.out.println("开始学习"+y+"年！");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(y==4){
                        System.out.println("学有所成毕业了！！");
                        notify();
                        break;
                    }
                }
            }
        });
// cannot be referenced from a static context

        Thread threadB = new Thread(() -> {
            synchronized(this){
                try {
                    wait();
                    System.out.println("开始找工作了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        threadB.start();
        threadA.start();

    }

}
