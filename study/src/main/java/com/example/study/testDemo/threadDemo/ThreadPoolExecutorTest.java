package com.example.study.testDemo.threadDemo;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {
    private static int taskCount =45;//执行任务数
    private static AtomicInteger taskCountExecuted;//实际执行任务数

    public static void main(String[] args) {
        taskCountExecuted = new AtomicInteger();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                20,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(30)//任务队列
         );

        System.out.println("z总任务数："+taskCount);
        long start = System.currentTimeMillis();
        for(int i= 0 ;i<taskCount;i++){
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println("已执行第" + taskCountExecuted.addAndGet(1) + "个任务！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            try {
                executor.execute(thread);
            } catch (Exception e) {
                taskCount = executor.getActiveCount()+executor.getQueue().size();
                System.out.println(" executor.getActiveCount()+executor.getQueue().size() {} "+taskCount);
            }
        }

        long end= 0;
        System.out.println("【线程池任务】线程池中曾经创建过的最大线程数getLargestPoolSize：" + executor.getLargestPoolSize());
        System.out.println("【线程池任务】线程池中线程数getPoolSize：" + executor.getPoolSize());
        System.out.println("【线程池任务】线程池中活动的线程数getActiveCount：" + executor.getActiveCount());
        System.out.println("【线程池任务】队列中等待执行的任务数getQueue：" + executor.getQueue().size());
        System.out.println("【线程池任务】线程池已执行完任务数getCompletedTaskCount：" + executor.getCompletedTaskCount());
        System.out.println("====================================================================");
        System.out.println("任务数 <= 核心线程数时，线程池中工作线程数 = 任务数\n" +
                "核心线程数 + 队列容量 < 任务数 <= 最大线程数 + 队列容量时，工作线程数 = 任务数 - 队列容量");

        //完成数等于任务数，跳出循环
        while(executor.getCompletedTaskCount() < taskCount){
            end = System.currentTimeMillis();
        }
        System.out.println(taskCountExecuted + "个任务已执行,总耗时：" + (end - start));
        executor.shutdown();
    }

}
