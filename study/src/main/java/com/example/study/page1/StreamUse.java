package com.example.study.page1;

import com.example.study.TestUtil.CommonUseObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUse {

    public static void main(String[] args) {
//        learnStream();
//        creatStream();
//        testUseStream();
//        reduce3th();
        learnFlatMap();
    }



    private static void learnStream() {
        //首先，创建一个1-6乱序的List
        List<Integer> lists = new ArrayList<>();
        lists.add(4);
        lists.add(3);
        lists.add(6);
        lists.add(1);
        lists.add(5);
        lists.add(2);

        //看看List里面的数据是什么样子的先
        System.out.print("List里面的数据:");
        for (Integer elem : lists) System.out.print(elem + " ");// 4 3 6 1 5 2

        System.out.println();

        //最小值
        System.out.print("List中最小的值为:");
        Stream<Integer> stream = lists.stream();
        Optional<Integer> min = stream.min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());//1
        }


        //最大值
        System.out.print("List中最大的值为:");
        lists.stream().max(Integer::compareTo).ifPresent(System.out::println);//6

        //排序
        System.out.print("将List流进行排序:");
        Stream<Integer> sorted = lists.stream().sorted();
        sorted.forEach(elem -> System.out.print(elem + " "));// 1 2 3 4 5 6

        System.out.println();

        //过滤
        System.out.print("过滤List流，只剩下那些大于3的元素:");
        lists.stream()
                .filter(elem -> elem > 3)
                .forEach(elem -> System.out.print(elem + " "));// 4 5 6

        System.out.println();

        //过滤
        System.out.println("过滤List流，只剩下那些大于0并且小于4的元素:\n=====begin=====");
        lists.stream()
                .filter(elem -> elem > 0)
                .filter(elem -> elem < 4)
                .sorted(Integer::compareTo)
                .forEach(System.out::println);// 1 2 3

        System.out.println("=====end=====");
        //经过了前面的这么多流操作，我们再来看看List里面的值有没有发生什么改变
        System.out.println("原List里面的数据:");
        for (Integer elem : lists) System.out.print(elem + " ");// 4 3 6 1 5 2
    }

    /**
     *
     * @description Java 8 创建 Stream 的 10 种方式，我保证你受益无穷!.md
     * @author ltj
     * @date 2021/7/2 17:13
     * @param
     * @return void
     */
    public static  void creatStream(){
        System.out.println("===============================创建Stream=====================================");
        //1111Stream.of 可变参数
        Stream<String> stringStream = Stream.of("天津", "你真", "帅", "哈哈哈哈");
        String s = stringStream.collect(Collectors.joining());
        System.out.println(s);

        //2222Stream.of 数组
        String[] strArray = new String[]{"sss","2222","dffsd"};
        Stream<String> stringStream1 = Stream.of(strArray);
        String s1 = stringStream1.collect(Collectors.joining());
        System.out.println(s1);

        //33333、Arrays.stream
        String[] values = new String[]{"A", "B", "C"};
        Stream<String> stream3 = Arrays.stream(values);
        System.out.println("stream3:" + stream3.collect(Collectors.joining()));
    }

    //c测试流的使用
    public static void testUseStream(){
        List<Integer> lists = Arrays.asList(CommonUseObject.createIntegerArray());

        //最小值
        System.out.print("List中最小的值为:");
        Integer num = lists.stream().min(Integer::compareTo).get();
        System.out.println("最小值:"+num);

        //最大值
        System.out.print("List中最大的值为:");
        num = lists.stream().max(Integer::compareTo).get();
        System.out.println("最大值:"+num);

        //排序
        System.out.print("将List流进行排序:");
        List<Integer> newList = lists.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("排序:"+newList.toString());

        //自定义排序
        System.out.print("将List流进行自定义排序:");
        lists = Arrays.asList(CommonUseObject.createIntegerArray());
        List<Integer> newList1 = lists.stream().sorted((x,y)->y-x).collect(Collectors.toList());
        System.out.println("自定义排序:"+newList1.toString());

        //过滤
        System.out.print("过滤List流，只剩下那些大于3的元素:");
        newList = lists.stream().filter(s->s>3).collect(Collectors.toList());
        System.out.println("过滤:"+newList.toString());


        //过滤
        System.out.println("过滤List流，只剩下那些大于0并且小于4的元素:\n=====begin=====");
        newList = lists.stream().filter(s->s>3 && s<50).collect(Collectors.toList());
        System.out.println("过滤:"+newList.toString());

        //经过了前面的这么多流操作，我们再来看看List里面的值有没有发生什么改变
        System.out.print("原List里面的数据:");
        lists.stream().forEach(e-> System.out.print(e+" 、"));
    }


    private static void reduce3th() {
        List<Integer> lists = new ArrayList<>();
        lists.add(2);
        lists.add(3);
        lists.add(4);
//        Integer sum = lists.stream()

       Integer s=  lists.stream().reduce(3,(a, b) -> a + b);
        System.out.println(s);
        Integer ss=  lists.stream().reduce((a, b) -> a + b).get();
        System.out.println(ss);
        Integer product = lists.parallelStream().reduce(2, (a, b) -> a + b * 2,
                (a, b) -> a + b);
        // 8 12 16
        System.out.println("product:" + product);//48
    }


    private static void learnFlatMap() {
        //(广州  深圳  上海  北京)的全拼的一些组合,下面我们就把每一个城市都划分一下
        List<String> citys = Arrays.asList("GuangZhou ShangHai", "GuangZhou ShenZhen",
                "ShangHai ShenZhen", "BeiJing ShangHai", "GuangZhou BeiJing", "ShenZhen BeiJing");

        //这里打印的数组对应的地址
        citys.stream().map(mCitys -> Arrays.stream(mCitys.split(" "))).forEach(System.out::println);//note1

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        //流里面的元素还是一个数组
        citys.stream()
                .map(mCities -> Arrays.stream(mCities.split(" ")))//流里面的每个元素还是数组
                .forEach(cities ->cities.forEach(city-> System.out.print(city+" ")));//note2

        System.out.println("111111111111111111111");
        System.out.println("222222222222222222222");

        //直接一个flatMap()就把数组合并到映射流里面了
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).forEach(System.out::println);//note3

        System.out.println();

        //使用distinct()方法去重！
        citys.stream().flatMap(mCities->Arrays.stream(mCities.split(" "))).distinct().forEach(System.out::println);//note4

    }
}
