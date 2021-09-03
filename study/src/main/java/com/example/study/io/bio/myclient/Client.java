package com.example.study.io.bio.myclient;

import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

import java.io.*;
import java.net.Socket;

/**
 * 阻赛的IO创建客户端
 */
public class Client {
    private static int DEFAULT_SERVER_PORT=12345;
    private  static String DEFAULT_IP = "127.0.0.1";
    //只传信息
    public static void send(String expression) { send(8081,expression); }

    public static void send(int port, String expression ){
        System.out.println("客户端要发的信息为："+expression);
        Socket socket =null;
        BufferedReader in = null;
        DataOutputStream out = null;
        try {
            socket = new Socket(DEFAULT_IP, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(expression);
            String re = in.readLine();
            System.out.println("客户端接收服务端，返回的结果为："+re);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in =null;
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out =null;
            }
            if (socket != null) {
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
