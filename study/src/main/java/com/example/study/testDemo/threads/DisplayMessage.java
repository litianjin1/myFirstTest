package com.example.study.testDemo.threads;


public class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int j=0;j<15;j++){

            System.out.println("zzz:"+message+"////"+j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message+"睡了1秒");
//Thread.yield();
        }

    }
}

class GuessANumber extends Thread {
    private String number;
    public GuessANumber(String number) {
        this.number = number;
    }
    @Override
    public void run() {
        for(int j=0;j<15;j++){
         /*   try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("ttt="+number+"执行了"+j);
//            Thread.yield();

        }
    }
}


class ThreadClassDemo {

    public static void main(String [] args) {
     /*   Runnable hello = new DisplayMessage("线程1");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(false);
        thread1.setName("线程1");
        System.out.println("Starting 线程1 thread...");
        thread1.start();

      */



        System.out.println("Starting thread3...");
        Thread thread3 = new GuessANumber("线程3");
/*        try {
            thread3.join();
        }catch(InterruptedException e) {
            System.out.println("Thread interrupted.");
        }*/
   /*     System.out.println("Starting thread4...");
        Thread thread4 = new GuessANumber("线程4");
        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.start();
        */
        Runnable bye = new DisplayMessage("线程2");
        Thread thread2 = new Thread(bye);
        System.out.println("Starting 线程2 thread...");

        thread2.start();
        thread3.start();
        try {
            thread2.sleep(5000);
            System.out.println("======================55555======================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main() is ending...");
    }
}
