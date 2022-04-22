package com.example.study.testDemo.io.nio.channel.socketChannelDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelTest1 {

    public static void main(String[] args) throws Exception{
        //第一步先来个简单小例子，基础
//        serverSocketChannel();

        //socketChannel
        socketChannel();
    }

    //第一步先来个简单小例子，serverSocketChannel
    public static  void serverSocketChannel() throws Exception{
        int port = 8888;
        //输出的内容
        ByteBuffer buffer = ByteBuffer.wrap("hello world".getBytes());

        //1、先创建 打开一个 ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2、绑定socket,监听新链接
        ssc.socket().bind(new InetSocketAddress(port));

        //3、设置非阻塞
        ssc.configureBlocking(false);

        //4、循环等待监听
        while (true){
            System.out.println("等待链接的到来。。。。。。");

            //5、获取通道
            SocketChannel sc = ssc.accept();
            //没有链接，socket返回的null
            if(sc == null){
                System.out.println(sc);
                Thread.sleep(3000);
            }else {
                System.out.println("访问的链接地址：" + sc.socket().getRemoteSocketAddress());
                //指针从0开始
                buffer.rewind();
                sc.write(buffer);
                sc.close();
            }


        }

    }


    //socketChannel
    public static void socketChannel() throws Exception {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));

/*        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));*/
        socketChannel.configureBlocking(false); //设置非阻塞
        socketChannel.isOpen();      // 测试SocketChannel是否为open状态
        socketChannel.isConnected();    //测试SocketChannel是否已经被连接
        socketChannel.isConnectionPending();    //测试SocketChannel是否正在进行连接
        socketChannel.finishConnect();    //校验正在进行套接字连接的SocketChannel是否已经完成连接

        //设置和获取参数
//        socketChannel.setOption(StandardSocketOptions.SO_BROADCAST,true);


        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        socketChannel.read(byteBuffer);
        socketChannel.close();
        System.out.println("test end!");
    }
}
