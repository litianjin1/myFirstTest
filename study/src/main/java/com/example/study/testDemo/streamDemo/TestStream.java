package com.example.study.testDemo.streamDemo;

import com.example.study.testDemo.TestUtil.CommonUseObject;
import com.example.study.facade.User;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    /*
     *  测试流的示例,统计
     * @description
     * @author ltj
     * @date 2021/8/10 16:16
     * @param
     * @return void
     */
    public  static void testOne(){
        List<User> userList = CommonUseObject.getListUser();
//        userList.stream().forEach(e-> System.out.println(e.toString()));
        IntSummaryStatistics intSummaryStatistics = userList.stream().mapToInt(m -> m.getAge()).summaryStatistics();
        List<Integer> collect = userList.stream().map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println("map "+collect);
        List<String> strings = Arrays.asList("a，b，c", "", "b，c", "e，f，g", "a，b，cd","", "jk，l");
        Stream<String> stringStream = strings.stream().filter(e -> !e.isEmpty()).flatMap(e -> {
            String[] strA = e.split("，");
            Stream<String> stream = Arrays.stream(strA);
            return stream;
        });
        List<String> collect1 = stringStream.collect(Collectors.toList());
        System.out.println(collect1);
        //统计
        System.out.println("intSummaryStatistics "+intSummaryStatistics);
        System.out.println("getMax "+intSummaryStatistics.getMax());
        System.out.println("getAverage "+intSummaryStatistics.getAverage());
        System.out.println("getCount "+intSummaryStatistics.getCount());
        System.out.println("getMin "+intSummaryStatistics.getMin());
        System.out.println("getSum "+intSummaryStatistics.getSum());
        System.out.println("getClass "+intSummaryStatistics.getClass());
    }

    /*
     * @description -- Stream 完整实例
     * @author -- ltj
     * @date -- 2021/8/10 16:28
     * @param args
     * @return -- void
     */
    public static void main(String args[]){
        testOne();
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //并行流
        strings.parallelStream().forEach(e-> System.out.println(e));
        System.out.println("列表: " +strings);
        System.out.println("随机数: ");
        // 输出10个随机数
        Random random = new Random();
        for(int i=0; i < 10; i++){
            System.out.println(random.nextInt());
        }

        long count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

       List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

       String  mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
        System.out.println("随机数: ");

        random.ints().limit(10).sorted().forEach(System.out::println);

        // 并行处理
        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为: " + count);
    }

    @Test
    public void testMax(){
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序（从大到小排序）
        Optional<Integer> max2 = list.stream().max((o1, o2) -> o2 - o1);
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }

}
