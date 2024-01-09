package com.example.study.testDemo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTheadPool {

    // 创建线程池
    public static void main(String[] args) {
        // 单个线程
//         ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 创建一个固定的线程池的大小
//         ExecutorService executorService = Executors.newFixedThreadPool(5);
        // 可伸缩的
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i=1; i<=80; i++){
                //使用线程池之后创建线程
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+ " ok");
                });
            }
        } finally {
            executorService.shutdown();
        }
    }

}
