package com.example.study.testDemo.io.bio.myserver;


import java.io.*;
import java.net.Socket;

/**
 * 客户端线程
 * 客户端消息处理线程ServerHandler源码
 * @author yangtao__anxpp.com
 * 用于处理一个客户端的Socket链路
 * */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        DataOutputStream out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out =new DataOutputStream(socket.getOutputStream());
            String expression ;
            while(true){
                //通过BufferedReader读取一行
                //如果已经读到输入流尾部，返回null,退出循环
                //如果得到非空值，就尝试计算结果并返回
                if((expression = in.readLine())==null) break;
                 System.out.println("服务器收到消息："+expression);

                out.writeUTF("谢谢连接我：" + socket.getLocalSocketAddress() + "Goodbye!");


            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out =null;
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in =null;
            }
            if (socket == null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket=null;
            }
        }
    }
}
