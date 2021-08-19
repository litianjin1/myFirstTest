package com.example.demo.io;

import java.io.*;

public class TestBufferIOAndCommonIo1 {


    /**
     * 普通字节流和缓冲字节流的效率差异就很明显了，达到了245倍
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Mu/test.txt");
        File parent =file.getParentFile();
        System.out.println(parent.getAbsolutePath());
        if(!parent.exists()){
            parent.mkdirs();
            if(!file.exists()){
                file.createNewFile();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3000000; i++) {
            sb.append("abcdefghigklmnopqrstuvwsyz");
        }
        byte[] bytes = sb.toString().getBytes();

        long start = System.currentTimeMillis();
        write(file, bytes);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        bufferedWrite(file, bytes);
        long end2 = System.currentTimeMillis();

        System.out.println("普通字节流耗时：" + (end - start) + " ms");
        System.out.println("缓冲字节流耗时：" + (end2 - start2) + " ms");

    }

    // 普通字节流
    public static void write(File file, byte[] bytes) throws IOException {
        OutputStream os = new FileOutputStream(file);
        os.write(bytes);
        os.close();
    }

    // 缓冲字节流
    public static void bufferedWrite(File file, byte[] bytes) throws IOException {
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(file));
        bo.write(bytes);
        bo.close();
    }
}
