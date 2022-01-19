package com.example.study.testDemo.threadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static double year;

    public static void main(String[] args) {
        //实例化一个锁和Condition
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //线程A，练习唱跳rap
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                for (year = 0.5; year <= 5; year += 0.5) {
                    System.out.println("开始练习唱跳rap：已练习" + year + "年");
                    Thread.sleep(288);
                    //众所周知，练习两年半即可出道
                    if (year == 2.5) {
                        System.out.println("===========================>练习时长两年半，出道！！！");
                        //唤醒等待中的线程
                        condition.signal();
                        //这里的break也是个彩蛋，去掉它触发隐藏关卡
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //解锁
                lock.unlock();
            }
        });
        //线程B，练习打篮球
        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                //让当前线程等待
                condition.await();
                System.out.println("开始练习打篮球");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        //启动顺序其实不影响，先启动B目的是增加B先拿到锁的几率，这样才能体现是condition产生了效果
        threadB.start();
        //如果觉得先启动B不能保证B先拿到锁，可以在这里sleep
        threadA.start();
    }
}
