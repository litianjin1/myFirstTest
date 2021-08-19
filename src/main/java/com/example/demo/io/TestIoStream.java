package com.example.demo.io;

import com.example.demo.facade.User;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

public class TestIoStream {

    public static void main(String[] args) {
//        mydemo();
//        fileStream();
//        rederStream();
        objectOutStream();
        objectInputStream();
    }

    //filestream

    public static void fileStream(){
        FileInputStream in = null;
        FileOutputStream out = null;
        //准备缓冲字节数组，大小为1024个字节
        byte[] buf = new byte[1024];
        //开始时间
        long start = System.currentTimeMillis();
        try {
            in = new FileInputStream("D:\\file\\a.txt");
            //in读取字节，将读取的字节保存到buf中。len为in向buf中保存的字节数
            int cahr = in.read();
            System.out.println((char)cahr);

            int len = in.read(buf);

            int three = in.read(buf,5,8);
            String s = new String(buf);
            System.out.println("|||||||"+s +"||||||||");
            //读取完成之后，释放资源
            in.close();
            //通过buf打印结果
            System.out.println(new String(buf, 0, len));
             out = new FileOutputStream("D:\\file\\to.txt");
            //将buf中的字节数组写入到to.txt中
            out.write(buf, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //结束时间
        long end = System.currentTimeMillis();

        //打印运行时间
        System.out.println("运行时间为："+(end - start));
    }


    public static void  mydemo(){
        InputStream is = null;
        OutputStream os = null;

        try {
            //abcdefghijk
            File file = new File("D:\\file\\a.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            is = new FileInputStream(file);
            byte[] bt = new byte[1024];
            //read(byte[] b, int off, int len)：从输入流中读取长度为 len 的数据，从数组 b 中下标为 off 的位置开始放置读入的数据，读完返回读取的字节数。
            int len = is.read(bt,2,5);
            System.out.println(len);
            String s="";
            if(len>0){
                //
               s =  new String(bt,2,len);
            }
           StringBuilder sb = new StringBuilder().append(s).append("gggggggg1111111");
            byte[] nbt = sb.toString().getBytes();


            os= new FileOutputStream("D:\\file\\c.txt");
            os.write(nbt,0,nbt.length);
            os.write("ssss".getBytes());
            os.write("bnmsaas".getBytes());
            os.write("plm".getBytes());

            System.out.println(new String(nbt));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void rederStream(){
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //abcdefghijk
            File file = new File("D:\\file\\a.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            is = new FileInputStream(file);
            os= new FileOutputStream("D:\\file\\c.txt");

            br = new BufferedReader(new InputStreamReader(is));
            bw = new BufferedWriter(new OutputStreamWriter(os));
            String temp =null ;
            while((temp = br.readLine())!=null){
                System.out.println(temp);
                bw.write(temp);
                bw.newLine();
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //对象序列化
    public static  void  objectOutStream(){
        try {
           File f =  new File("D:\\file\\d.txt");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            User user =new User();
            user.setName("张三");
            user.setMoney(new BigDecimal("320"));
            user.setAge(17);
            user.setTestTime(new Timestamp(System.currentTimeMillis()));

            oos.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //对象序列化
    public static  void  objectInputStream(){
        try {
           File f =  new File("D:\\file\\d.txt");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));

            try {
                Object o = ois.readObject();
                User u =  (User)o;
                System.out.println(u.toString());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
