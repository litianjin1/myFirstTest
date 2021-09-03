package com.example.study.soketTest;

import java.io.*;
import java.net.Socket;

public class MyGreetingClient
{
    public static void main(String [] args)
    {
        try {
            System.out.println("客户端开始了！！！");
            Socket socket = new Socket("localhost", 8081);
            System.out.println("获取服务端的信息");

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("这是客户端向服务端发送的信息，哇毕八步"+socket.getInetAddress());

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("服务端的信息是："+dataInputStream.readUTF());
            System.out.println("给服务端发送信息！！！");

            inputStream.close();
            dataInputStream.close();
            outputStream.close();
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}