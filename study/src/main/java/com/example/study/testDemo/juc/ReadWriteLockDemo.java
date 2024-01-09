package com.example.study.testDemo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 读写锁ReadWriteLock
 * 读写锁：更加细粒度的锁
 * 读-读：可以共存
 * 读-写：不能共存
 * 写-写：不能共存
 * JUC的目的，就是将锁的粒度变的更细，提高并发效率；至少读-读，可以共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache mycache = new MyCache();
        //开启5个线程 写入数据
        for (int i = 1; i <=5 ; i++) {
            int finalI = i;
            new Thread(()->{ 
                mycache.put(String.valueOf(finalI),String.valueOf(finalI));
            }).start();
        }
        //开启10个线程去读取数据
        for (int i = 1; i <=10 ; i++) {
            int finalI = i;
            new Thread(()->{
                String o = mycache.get(String.valueOf(finalI));
            }).start();
        }
    }
}

class MyCache{

    private volatile Map<String,String> map = new HashMap<>();
    //普通锁
    private Lock lock = new ReentrantLock();
    //使用读写锁
//    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        //写锁
        lock.lock();
//        lock.writeLock().lock();
        try {
            //写入
            System.out.println(Thread.currentThread().getName()+" 线程 开始写入");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+" 线程 写入完成");
        } finally {
            lock.unlock();
//            lock.writeLock().unlock();
        }
    }

    public String get(String key){
        //读锁
        lock.lock();
//        lock.readLock().lock();
        String o;
        try {
            System.out.println(Thread.currentThread().getName()+" 线程 开始读取");
            o = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 线程 读取完成");
        } finally {
            lock.unlock();
//            lock.readLock().unlock();
        }
        return o;
    }
}
