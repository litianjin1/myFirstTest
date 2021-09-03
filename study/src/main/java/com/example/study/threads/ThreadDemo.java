package com.example.study.threads;

public class ThreadDemo extends Thread{
    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
    }



    @Override
    public void run() {
        System.out.println("开始run");
        try {
            for(int i=0;i<4;i++){
                System.out.println(threadName+"第"+i+"次入睡！！！");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName+"中断异常！！！");
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("start---"+threadName);
        System.out.println(this);
        System.out.println("=====");
        if(null ==t ){
            //注意这个this，必须要传，表示调用我们这个对象；不传的话，默认调的是new thread的对象，start时不会调用我们重写的run方法。
            t= new Thread(this,threadName);
            t.start();
        }
    }
}

class TestThread{

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("thread-11");
        threadDemo1.start();

        ThreadDemo threadDemo2 = new ThreadDemo("thread-22");
        threadDemo2.start();



    }
}