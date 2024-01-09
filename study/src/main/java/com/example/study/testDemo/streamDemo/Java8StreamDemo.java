package com.example.study.testDemo.streamDemo;

import com.example.study.testDemo.streamDemo.bean.Person;
import org.apache.commons.lang.math.RandomUtils;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 从创建到使用
 */
public class Java8StreamDemo {

    public List<Person>  getPersonList(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23,"male", "New York"));
        personList.add(new Person("Jack", 7000, 27,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 45,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 19,"female", "New York"));
        personList.add(new Person("Owen", 9500, 44,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 34,"female", "New York"));
        return personList;
    }

    /**
     * 0、创建
     */
    @Test
    public void test00(){
        List<Person> personList = getPersonList();

//        1、通过 java.util.Collection.stream() 方法用集合创建流
        Stream<Person> stream = personList.stream();

        Stream<Person> personStream = personList.parallelStream();

//        2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
        IntStream stream1 = Arrays.stream(new int[]{3, 2, 1});

//      3、使用Stream的静态方法：of()、iterate()、generate()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 45, 6, 7);
        Stream<String> asa = Stream.of("asa", "sda", "asdas11");

        Stream<Integer> limit = Stream.iterate(0, x -> x + 2).limit(5);
        limit.forEach(System.out::println);

        Stream<Person> generate = Stream.generate(() -> new Person("Alisa", 7900, 34, "female", "New York")).limit(3);
        Stream<String> generate1 = Stream.generate(() -> UUID.randomUUID().toString()).limit(5);
        generate.forEach(System.out::println);
        generate1.forEach(System.out::println);

    }


    /**
     * 1、遍历/匹配
     */
    @Test
    public void test01(){
        List<Person> personList = getPersonList();
        // 遍历输出符合条件的元素
        personList.stream().filter(e->e.getSalary()>8000).forEach(System.out::println);

        System.out.println();
        // 匹配第一个
        Optional<Person> first = personList.stream().filter(e -> e.getSalary() > 8000).findFirst();
        System.out.println("第一个："+first.get());

        // 匹配任意（适用于并行流）
        Optional<Person> any = personList.parallelStream().filter(e -> e.getSalary() > 8000).findAny();
        System.out.println("匹配任意："+any.get());

        // 是否包含符合特定条件的元素
        boolean b = personList.stream().allMatch(e -> e.getSalary() > 18000);
        System.out.println("是否包含符合特定条件的元素:"+b);

    }
    /**
     * 2、聚合（max/min/count)
     */
    @Test
    public void test02(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        //最长的字符串
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串:"+max.get());


        //获取Integer集合中的最大值
        List<Integer> list1 = Arrays.asList(7, 6, 9, 4, 11, 6);
        Optional<Integer> max1 = list1.stream().max(Integer::compareTo);
        System.out.println("获取Integer集合中的最大值:"+max1.get());

        // 自定义排序（从大到小排序）
        Optional<Integer> max2 = list1.stream().max((o1, o2) -> o1 - o2);
        System.out.println("自定义排序:"+max2.get());

        //最大工资
        Optional<Person> max3 = getPersonList().stream().max(Comparator.comparing(Person::getSalary));
        System.out.println("最大工资"+max3.get());

        //工资大于8000的人数  count
        long count = getPersonList().stream().filter(e -> e.getSalary() > 8000).count();
        System.out.println(" 工资大于8000的人数 :"+count);


    }


    /**
     * 3、映射(map/flatMap)  mapToInt、mapToLong、mapToDouble
     */
    @Test
    public void test03(){
//          1  英文字符串数组的元素全部改为大写。整数数组每个元素+3。
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);

        List<String> collect = Arrays.stream(strArr).map(e -> e.toUpperCase()).collect(Collectors.toList());

        List<Integer> collect1 = intList.stream().map(e -> e + 3).collect(Collectors.toList());

        System.out.println("1英文字符串数组的元素全部改为大写 : "+collect);
        System.out.println("1整数数组每个元素+3 : "+collect1);

//      2  将员工的薪资全部增加1000。

        List<Person> personList = getPersonList();
        List<Person> collect2 = personList.stream().map(e -> {
            //这里用新对象就不会改变原集合 ， 如果直接在 e 的基础上操作会改变原集合
            Person person = new Person(e.getName(), e.getSalary() + 1000, e.getAge(), e.getSex(), e.getArea());
            return person;
        }).collect(Collectors.toList());
        System.out.println("=========  2、将员工的薪资全部增加1000 (不会改变原集合) ======");
        System.out.println("修改前 : "+personList);
        System.out.println("修改后 ："+collect2);
//     3   将两个字符数组合并成一个新的字符数组
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect3 = list.stream().flatMap(e -> {
            String[] split = e.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());

        System.out.println("3、将两个字符数组合并成一个新的字符数组 ： " + collect3);


//     4、 输出字符串集合中每个字符串的长度
        List<String> stringList = Arrays.asList("mu", "CSDN", "hello",
                "world", "quickly");

        int[] ints = stringList.stream().mapToInt(e -> e.length()).toArray();
        System.out.println("4、 输出字符串集合中每个字符串的长度 :" );
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
        System.out.println();
//      5、  求最大最小值、求和、求平均值

        int sum = stringList.stream().mapToInt(e -> e.length()).sum();
        OptionalDouble average = stringList.stream().mapToInt(e -> e.length()).average();
        OptionalInt max = stringList.stream().mapToInt(e -> e.length()).max();
        OptionalInt min = stringList.stream().mapToInt(e -> e.length()).min();
        System.out.println("求最大最小值、求和、求平均值 : sum --" + sum +"  average:"+average.getAsDouble()+"  max:"+max.getAsInt()+"  min:"+min.getAsInt());
    }

    /**
     * 4、 归约(reduce)
     * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操
     */
    @Test
    public void test04(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println("求和方式1 :" +reduce.get());
        // 求和方式2
        Integer reduce1 = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("求和方式2 :"+reduce1);

        // 求和方式3
        Integer reduce2 = list.stream().reduce(0, Integer::sum);

        System.out.println("求和方式3 :"+ reduce2);
        // 求乘积

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2 (指定值参与进大小比较)

        Integer max2 = list.stream().reduce(100, Integer::max);

        System.out.println("求最大值写法2 : "+max2);
    }


    /**
     * 5、收集(collect) toList/toSet/toMap
     */
    @Test
    public void test05(){
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);

        //不会去重
        Set<Integer> collect = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
        List<Integer> collect1 = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        getPersonList().stream().collect(Collectors.groupingBy(e->e.getSalary(),TreeMap::new,Collectors.toList()));
// 利用treeMap有序的特性
//        Map<String, List<ShiQc>> map = shiQcList.stream().collect(Collectors.groupingBy(m -> (m.getApplyName() + m.getIdCode()), TreeMap::new, Collectors.toList()));

        System.out.println(" set 会去重:"+collect);
        System.out.println("list 不会去重:"+collect1);
    }
}
