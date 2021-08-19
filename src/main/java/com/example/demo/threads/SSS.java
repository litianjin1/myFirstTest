package com.example.demo.threads;

public class SSS  extends Thread{
    @Override
    public void run() {
        System.out.println(222222);
    }
}

class  Test{
    public static void main(String[] args) {
        Thread sss = new Thread(new Thread(),"ssss");
        sss.start();
    }
}

