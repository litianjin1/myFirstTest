package com.example.study.io.testIo;

import java.io.*;
import java.util.Scanner;

public class TestIo {
    public static void main(String[] args) {
/*
        String classPath = TestIo.class.getResource("/").getPath();

        System.out.println("项目路径：" + classPath);
        String dirname = "E:/workspace/testDemo/target/classes";

        test1(dirname);
*/
        printbanner();
//        testSccanner();
/*        try {
            test3();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
//        test2();
    }

    /**
     * 获得文件的路径
     * 打印文件到控制台
     */
    public static  void printbanner(){

        //000获取src/ClassPath下的文件 111.txt 的绝对路径
        System.out.println("00 "+TestIo.class.getClassLoader().getResource("text/banner.txt").getPath());


        //11获取 src/ClassPath的绝对路径
        System.out.println("11 "+TestIo.class.getClassLoader().getResource(".").getPath());
        //222获取 src/ClassPath的绝对路径
        System.out.println("222 " +TestIo.class.getClassLoader().getResource("").getPath());
        //333获取 src/ClassPath的绝对路径
        System.out.println("33 "+Thread.currentThread().getContextClassLoader().getResource(".").getPath());
        //44获取 src/ClassPath的绝对路径
        System.out.println("44 "+Thread.currentThread().getContextClassLoader().getResource("").getPath());

        //555获取项目的绝对路径
        System.out.println("55 "+System.getProperty("user.dir"));

        //66获取当前类文件的绝对目录，不包括自己的上级目录
        System.out.println("66 "+TestIo.class.getResource(".").getPath());
        //77获取当前类文件的绝对目录，不包括自己的上级目录
        System.out.println("77 "+TestIo.class.getResource("").getPath());

        
        
        String path =TestIo.class.getClassLoader().getResource("text/banner.txt").getPath();
        System.out.println(path);
        File f =new File(path);
        try {
            FileReader br = new FileReader(f);
            int c;
           String s =  TestIo.class.getResource(".").getPath();
            File file = new File(s.substring(1));
            File file1 = new File(file, "hello1.txt");

            char[] chars = new char[1024];
            FileWriter writer = new FileWriter(file1,true);
            StringBuilder sb = new StringBuilder();
            while((c = br.read(chars))!=-1){
                System.out.println(c);
                sb.append(new String(chars,0,c));
                sb.append("\n\r");
            }

            writer.write(sb.toString());
            br.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static void testSccanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
  /*      if(scanner.hasNext()){
            String next = scanner.next();
            System.out.println(next);
        }*/

        if(scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(s);
        }

        scanner.close();
    }
    public static  void test1 (String dirname){
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("目录 " + dirname);
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    test1(dirname + "/" + s[i]);
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirname + " 不是一个目录");
        }
    }


    public static  void test2 (){
            try {
              byte [] bt = {'w','s','p','q','w','e',' ','h','e','l'};
                File fl = new File("text.txt");
                OutputStream os = new FileOutputStream(fl);
                os.write(bt);

                os.close();
                InputStream is = new FileInputStream(fl);
                byte [] bt2 = new byte[5];
                int read  ;
                StringBuffer sb = new StringBuffer();
                while ((read = is.read(bt2)) !=-1){
                    String s = new String(bt2);
                    sb.append(new String(bt2));
                    System.out.println(s);
                }
                System.out.println(sb.toString());
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static  void test3() throws FileNotFoundException,UnsupportedEncodingException,IOException{
        //往文件 a.txt输入中文 ，再取出打印在控制台。
        File file = new File("a.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        OutputStreamWriter writer = new OutputStreamWriter(fos,"utf-8");

        writer.append("你好，李天津");
        writer.append("\n\t");
        writer.append("结束了");
        writer.append("\n\t");

        writer.flush();

        writer.append("继续啊");
        writer.append("\n\t");

        writer.append("继续啊~~~~阿萨大了");
        writer.append("\n\t");

        writer.close();
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        StringBuffer sb = new StringBuffer();
        if (isr.ready() ){
            int c;
            while ((c= isr.read()) !=-1){
                sb.append((char) c);

            }
        }
        System.out.println("成功了吗？");
        System.out.println(sb.toString());
        isr.close();
        fis.close();

    }
}
