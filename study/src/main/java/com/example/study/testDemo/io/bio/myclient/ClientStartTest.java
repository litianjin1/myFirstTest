package com.example.study.testDemo.io.bio.myclient;

import java.util.Random;

public class ClientStartTest {
    public static void main(String[] args) {
        //启动客户端
        Random random = new Random(System.currentTimeMillis());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String info = random.nextInt(10)+"启动你好";
                    System.out.println(info);
                    Client.send(info);

                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }



            }
        }).start();
    }
}
