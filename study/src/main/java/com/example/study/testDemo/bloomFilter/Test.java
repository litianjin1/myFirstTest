package com.example.study.testDemo.bloomFilter;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Test {


//    一亿个对象过滤，要求内存占用小于1G
    public static void main(String[] args) {
        Object key = getFixedPerson(now);
        int h;
        int index = key == null ? 0 : (Integer.MAX_VALUE - 1 - 16) & ((h = key.hashCode()) ^ (h >>> 16));
        System.out.println(index > 0 ? index : -index); ;
        System.out.println("================================================"); ;


        //使用list测试 ，list方案以失败告终 ； 要用list也不是不行，装不了一个亿就分批次呗，酱紫解决了内存的问题，但是耗时解决不了，就按照上面的1000w0.3s来计算，一个亿至少也得3s，还是有点拉跨
//        test00();
        //使用 布隆过滤器过滤
        test01();
    }

    //1、使用list测试
    public static void test00() {
        //实例化
        ArrayList<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.addAll(getPersonList(500000));
        }
        //add一个确定的person
        arrayList.add(getFixedPerson(now));
        long start = System.currentTimeMillis();
        System.out.println(arrayList.contains(getFixedPerson(now)));
        System.out.println("arrayList内对象数量" + arrayList.size());
        long end = System.currentTimeMillis() - start;
        System.out.println("耗时(ms)：" + end + ",消耗内存(m)：" + (ObjectSizeCalculator.getObjectSize(arrayList) / (1024 * 1024)));

    }

    //2、使用 布隆过滤器过滤
    public static void test01(){
        System.out.println("============================================      以下使用布隆      ==============================================");
        //实例化
        MyBloomFilter filter = new MyBloomFilter();
        for (int i = 0; i < 20; i++) {
            //push到BloomFilter
            getPersonList(500000).forEach(person -> filter.push(person));
        }
        //push一个确定的对象
        filter.push(getFixedPerson(now));
        //判断这个对象是否存在
        long start = System.currentTimeMillis();
        System.out.println(filter.contain(getFixedPerson(now)));
        long end = System.currentTimeMillis() - start;
        System.out.println("bloomFilter内对象数量：" + filter.getCurrentBeanCount());
        System.out.println("耗时(ms)：" + end + ",消耗内存(m)：" + (ObjectSizeCalculator.getObjectSize(filter) / (1024 * 1024)));
    }
















    private static Random random = new Random();
    private static String[] names = {"黄某人", "负债程序猿", "谭sir", "郭德纲", "李狗蛋", "铁蛋", "赵铁柱", "蔡徐鸡", "蔡徐母鸡"};
    private static String[] addrs = {"二仙桥", "成华大道", "春熙路", "锦里", "宽窄巷子", "双子塔", "天府大道", "软件园", "熊猫大道", "交子大道"};
    private static String[] companys = {"京东", "腾讯", "百度", "小米", "米哈游", "网易", "字节跳动", "美团", "蚂蚁", "完美世界"};
    private static LocalDateTime now = LocalDateTime.now();

    //获取指定数量person
    private static ArrayList<Person> getPersonList(int count) {
        ArrayList<Person> persons = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            persons.add(getPerson());
        }
        return persons;
    }


    //随机生成person
    private static Person getPerson() {
        Person person = Person.builder()
                .name(names[random.nextInt(names.length)])
                .phone(18800000000L + random.nextInt(88888888))
                .salary(new BigDecimal(random.nextInt(99999)))
                .company(companys[random.nextInt(companys.length)])
                .ifSingle(random.nextInt(2))
                .sex(random.nextInt(2))
                .address("四川省成都市" + addrs[random.nextInt(addrs.length)])
                .createTime(LocalDateTime.now())
                .createUser(names[random.nextInt(names.length)]).build();
        return person;
    }

    //获得一个确定的person，需传入一个date，什么作用这里先别管，后面一看就懂
    private static Person getFixedPerson(LocalDateTime date) {
        Person person = Person.builder()
                .name("薇娅")
                .phone(18966666666L)
                .salary(new BigDecimal(99999))
                .company("天猫")
                .ifSingle(0)
                .sex(0)
                .address("上海市徐家汇某栋写字楼")
                .createTime(date)
                .createUser("老马").build();
        return person;
    }
}
