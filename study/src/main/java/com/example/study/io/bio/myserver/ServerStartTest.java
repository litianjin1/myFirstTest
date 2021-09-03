package com.example.study.io.bio.myserver;

import java.io.IOException;

public class ServerStartTest {
    public static void main(String[] args) {
        //启动服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerBetter.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();




    }
}
