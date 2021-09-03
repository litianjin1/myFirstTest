package com.example.study.soketTest;

// 文件名 GreetingServer.java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class MyGreetingServer extends Thread{
    private ServerSocket serverSocket;

    public MyGreetingServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(1000000);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            System.out.println("服务端开始了！！！");
            try {
                Socket socket = serverSocket.accept();
                System.out.println("getLocalPort:"+socket.getLocalPort() +" getInetAddress:"+socket.getInetAddress()+"  getSoTimeout:"+socket.getSoTimeout());

                System.out.println("开始获取客户端的请求信息！！");
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                System.out.println("dataInputStream"+dataInputStream.readUTF());

                System.out.println("给客户端的返回信息！！");
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("这是返给客户端的信息，说些什么呢，hello？"+socket.getRemoteSocketAddress() +" || "+socket.getInetAddress()+" || "+socket.getLocalSocketAddress());

                socket.close();
               /* inputStream.close();
                dataInputStream.close();
                outputStream.close();
                dataOutputStream.close();*/

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread myGreetingServer = new MyGreetingServer(8081);
        myGreetingServer.run();
    }
}