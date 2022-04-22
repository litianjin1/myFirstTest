package com.example.study.testDemo.io.nio.channel.fileChannelDemo;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest1 {

    public static void main(String[] args) throws Exception {

        //读取数据
        readData();

        System.out.println("==============================================================================");
        //写入数据
        writeData();

        System.out.println("==============================================================================");
        tansformData();
    }

    //读取数据
    public  static void readData() throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("E:\\pipeline\\testTxt\\01.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);

        while (read!=-1){
            buffer.flip();
            while (buffer.hasRemaining()){
                char s = (char)buffer.get();
                System.out.println(s);
            }
            buffer.clear();
            read = channel.read(buffer);
        }
        channel.close();
        System.out.println("读取结束");

    }



    //写入数据
    public  static void writeData() throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("E:\\pipeline\\testTxt\\02.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "good morning!!!";
        buffer.clear();
        buffer.put(str.getBytes());
        buffer.flip();
        channel.write(buffer);

        channel.close();
        System.out.println("写入结束");

    }

    //两通道传输
    public  static void tansformData() throws Exception{
        RandomAccessFile accessFile1 = new RandomAccessFile("E:\\pipeline\\testTxt\\01.txt", "rw");
        RandomAccessFile accessFile2 = new RandomAccessFile("E:\\pipeline\\testTxt\\03.txt", "rw");
        FileChannel fromchannel = accessFile1.getChannel();
        FileChannel tochannel= accessFile2.getChannel();


        long position = 0;
        long count = fromchannel.size();

        //方式一
        tochannel.transferFrom(fromchannel,position,count);

        //方式二
//        fromchannel.transferTo(position,count,tochannel);

        fromchannel.close();
        tochannel.close();
        System.out.println("两通道传输结束");

    }
}
