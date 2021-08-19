package com.example.demo.streamDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestDemoTwo {
    public static void main(String[] args) {
        testSplitStr();
        testBuffer();
        testStatic();
    }
    /*
     * @description -- stream的静态方法
     * @author -- ltj
     * @date -- 2021/8/11 13:26
     * @param
     * @return -- void
     */
    public static  void testStatic(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        stream.forEach(System.out::println);

        System.out.println("============================================");
        /**
         * iterate()方法，第一个参数是初始值，第二个参数是一个方法，对每个元素进行操作得到新值
         * 这个方法获取的是无限流，需要借助limit() 方法来截取
         */
        Stream<Integer> stream2 = Stream.iterate(1, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10
        System.out.println("============================================");
        /**
         * generate() 方法  返回无限无序流
         */
        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }

    /*
     * @description -- 使用 BufferedReader.lines() 方法，将每行内容转成流
     * @author -- ltj
     * @date -- 2021/8/11 14:53
     * @param
     * @return -- void
     */
    public static void testBuffer(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /* 
     * @description --  使用 Pattern.splitAsStream() 方法，将字符串分隔成流
     * @author -- ltj
     * @date -- 2021/8/11 15:11
     * @param 
     * @return -- void
     */
    public static  void testSplitStr(){
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("dada,fdfd,fgfg,we,dfaa,gffgfg,assa");
        stringStream.forEach(System.out::println);
    }
}
