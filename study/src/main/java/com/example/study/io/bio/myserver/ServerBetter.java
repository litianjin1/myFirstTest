package com.example.study.io.bio.myserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端源码__伪异步I/O
 * @author yangtao__anxpp.com
 * @version 1.0
*/
public final class ServerBetter {
    //默认端口号
    private static int DEFAULT_PORT =12345;
    //单例的serversocket
    private static ServerSocket serverSocket;
    //线程池 懒汉单例
    private  static ExecutorService executorService = Executors.newFixedThreadPool(60);
    //根据传入参数设置监听端口号 如果没有传入默认值；
    public static  void start() throws IOException{
        start(8081);
    }

    public synchronized static void start(int port) throws IOException{
        if (serverSocket != null) return;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，端口号："+port);
            //当没有客户端接入时，降阻塞在accept操作上。
            while(true){
                Socket socket = serverSocket.accept();
                //当有新客户端接入时，执行下面
                //创建一个新的线程处理这条socket链路。
                executorService.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //结束时关闭线程池
            executorService.shutdown();
            //后续清理工作
            if (serverSocket != null) {
                System.out.println("服务器已关闭");
                serverSocket.close();
                serverSocket =null;
            }
        }

    }

}
