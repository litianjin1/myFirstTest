package com.example.study.testDemo.base64Demo;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * base64编码实现的三种实现方式性能测试，推荐使用Java8提供的方法
 *
 */

public class Base64Test {

    public  static  void  testJava8(){
        try {

            String str = "你好 runoob?java8";
            // 使用基本编码  返回一个 Base64.Encoder ，编码使用基本型 base64 编码方案。
            String base64encodedString = java.util.Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);

            // 解码  返回一个 Base64.Decoder ，解码使用基本型 base64 编码方案。
            byte[] base64decodedBytes = java.util.Base64.getDecoder().decode(base64encodedString);
            System.out.println("原始字符串utf8: " + new String(base64decodedBytes,"utf-8"));

            //返回一个 Base64.Encoder ，编码使用 URL 和文件名安全型 base64 编码方案。
            base64encodedString = java.util.Base64.getUrlEncoder().encodeToString("http://127.0.0.1:8080/runoob?param=java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);

            //返回一个 Base64.Decoder ，解码使用 URL 和文件名安全型 base64 编码方案。
            byte[] urlDecoderbytes = java.util.Base64.getUrlDecoder().decode(base64encodedString);
            System.out.println("Base64 解码字符串 (URL) :"+new String(urlDecoderbytes,"utf-8"));

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = java.util.Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);

            byte[] decode = java.util.Base64.getMimeDecoder().decode(mimeEncodedString);
            System.out.println("Base64 解码字符串 (MIME) :" +new String(decode,"utf-8"));

        }catch(UnsupportedEncodingException e){
            System.out.println("Error :" + e.getMessage());
        }
    }
    /**
     * 实际测试编码与解码速度的话，Java 8提供的Base64比Apache Commons Codec提供的还要快
     * ，Apache Commons Codec提供的比sun.misc提供的还要快。
     * 因此在Java上若要使用Base64，这个Java 8的java.util提供的Base64类是首选！
     *
     *
     *
     * @param args
     */
    public static void main(String[] args){
        testJava8();


        //三种 编码方式
/*        sunMiscDemo();
        apacheCommonsCodecDemo();
        java8UtilDemo();*/

    }

    /**
     * 早期在Java上做Base64的编码与解码，会使用到JDK里sun.misc套件下的BASE64Encoder和
     * BASE64Decoder这两个类别，用法如下：
     *Base64的加密解密都是使用sun.misc包下的BASE64Encoder及BASE64Decoder的sun.misc.
     * BASE64Encoder/BASE64Decoder类。
     * 这个类是sun公司的内部方法，并没有在java api中公开过，不属于JDK标准库范畴，但在JDK中包含了该类，可以直接使用。
     * 但是在Eclipse和MyEclipse中直接使用,却找不到该类。解决方法如下：
     */
    public static void sunMiscDemo() {
        BASE64Encoder encoder = new BASE64Encoder();
        BASE64Decoder decoder = new BASE64Decoder();
        String str = "字串文字";
        String strEncoder = null;
        String strDecoder = null;

        Long startDate = new Date().getTime();
        for(int i = 0; i < 1000000; i++){
            //编码
            try {
                strEncoder = encoder.encode(str.getBytes("UTF-8"));
                //System.out.println("strEncoder=" + strEncoder);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //解码
            try {
                strDecoder = new String(decoder.decodeBuffer(strEncoder), "UTF-8");
                //System.out.println("strDecoder=" + strDecoder);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        Long endDate = new Date().getTime();
        System.out.println("SunMis test 100w次 加密解密耗时：" + (endDate - startDate));
    }

    /**
     * Apache Commons Codec有提供Base64的编码与解码功能，会使用到
     * org.apache.commons.codec.binary套件下的Base64类别
     */
    public static void apacheCommonsCodecDemo() {
        Base64 base64 = new Base64();
        String str = "字串文字";
        String strEncode = null;
        String strDecode = null;

        Long startDate = new Date().getTime();
        for(int i = 0; i < 1000000; i++){
            byte[] b = null;
            //编码
            try {
                strEncode = new String(base64.encode(str.getBytes("UTF-8")), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //解码
            try {
                strDecode = new String(base64.decode(strEncode.getBytes("UTF-8")), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


        }
        Long endDate = new Date().getTime();
        System.out.println("ApacheCommons  test 100w次耗时：" + (endDate - startDate));
    }

    /**
     * Java 8之后的作法
     * Java 8的java.util套件中，新增了Base64的类别，可以用来处理Base64的编码与解码，用法如下：
     *
     */
    public static void java8UtilDemo() {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        String str = "字串文字";
        String strEncoder = null;
        String strDecoder = null;

        Long startDate = new Date().getTime();
        for(int i = 0; i < 1000000; i++){
            //编码
            try {
                strEncoder = encoder.encodeToString(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //解码
            try {
                strDecoder = new String(decoder.decode(strEncoder), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Long endDate = new Date().getTime();
        System.out.println("Java8 test 100w次耗时：" + (endDate - startDate));

    }



}
