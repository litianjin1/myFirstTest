package com.example.study.testDemo.threads;

public class RunnableDemo implements Runnable{
    private Thread thread;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("开始创建runnable对象");
    }

    @Override
    public void run() {
        System.out.println("开始run");
        try {
            for(int i=0;i<4;i++){
                System.out.println(threadName+"第"+i+"次入睡！！！");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName+"中断异常！！！");
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public  void  start(){
        System.out.println("开始"+threadName);
        System.out.println(this);
        System.out.println("=====");
        if(null==thread){
            System.out.println(this);
            thread = new Thread(this,threadName);
            thread.start();
        }
    }


}

//测试
class TestRunnable{
    /*
     *
     * @description
     * @author ltj
     * @date 2021/8/10 10:39
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        RunnableDemo demo1 = new RunnableDemo("thread-1");
        demo1.start();

        RunnableDemo demo2 = new RunnableDemo("thread-2");
        demo2.start();
    }
}
