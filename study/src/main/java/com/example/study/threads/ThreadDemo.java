package com.example.study.threads;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo extends Thread{
    private Thread t;
    private String threadName;
    private String url;
    private String name;

    public ThreadDemo(String threadName,String url ,String name) {
        this.threadName = threadName;
        this.url = url;
        this.name = name;
    }



    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        try {
            webDownLoader.down(url,name);
            System.out.println("下载图片："+name);
        } catch (IOException e) {
            System.out.println("下载图片错误");;
        }
//        System.out.println("开始run");
//        try {
//            for(int i=0;i<4;i++){
//                System.out.println(threadName+"第"+i+"次入睡！！！");
//                Thread.sleep(2000);
//            }
//        } catch (InterruptedException e) {
//            System.out.println(threadName+"中断异常！！！");
//            e.printStackTrace();
//        }
//        System.out.println("Thread " +  threadName + " exiting.");
    }

/*    public void start() {
        System.out.println("start---"+threadName);
        System.out.println(this);
        System.out.println("=====");
        if(null ==t ){
            //注意这个this，必须要传，表示调用我们这个对象；不传的话，默认调的是new thread的对象，start时不会调用我们重写的run方法。
            t= new Thread(this,threadName);
            t.start();
        }
    }*/
}

class TestThread{

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("thread-11","http://image.hnol.net/c/2010-10/07/15/201010071539147211-2536937.jpg","1.jpg");
        ThreadDemo threadDemo2 = new ThreadDemo("thread-22","http://image.hnol.net/c/2012-07/03/23/201207032316537221-3194564.jpg","2.jpg");
        ThreadDemo threadDemo3 = new ThreadDemo("thread-33","http://image.hnol.net/c/2013-08/27/22/20130827220435791-4112852.jpg","3.jpg");

        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();

        ExecutorService ser = Executors.newFixedThreadPool(3);
//        ser.submit();



    }
}


//文件下载器
class WebDownLoader{

    public void down(String url,String name) throws MalformedURLException, IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }

}