package com.example.demo.redis;

import redis.clients.jedis.Jedis;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class redisTest {

        public static void main(String[] args) {
//            clientStart();
            testString();
            testList();
            testSet();

        }

        //测试链接
        public  static void  clientStart(){
            //连接本地的 Redis 服务
            Jedis jedis = new Jedis("localhost");
            // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
            // jedis.auth("123456");
            System.out.println("连接成功");
            //查看服务是否运行
            System.out.println("服务正在运行: "+jedis.ping());
        }


    //Redis Java String(字符串) 实例
    public static void testString() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        jedis.setnx("notExist","if not exist,set value");
        Boolean sss = jedis.exists("sss");
        Boolean notExist = jedis.exists("notExist");
        String set = jedis.getSet("notExist", "hello world");
        String setex = jedis.setex("setex", 30, "test");
        Long setex1 = jedis.ttl("setex");

        // 获取存储的数据并输出
 /*       System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
        System.out.println("redis 存储的字符串为: "+ jedis.get("notExist"));
        System.out.println("redis 存储的字符串为: "+ sss);
        System.out.println("redis 存储的字符串为: "+ notExist);
        System.out.println("redis 存储的字符串为: "+ set);*/
        System.out.println("redis 存储的字符串为: "+ setex);
        System.out.println("redis 存储的字符串为: "+ setex1);
    }

    //Redis Java List 实例
    public static void testList() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }

    //Redis Java keys 实例
    public static void testKeys() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
    //Redis Java set 实例
    public static void testSet() {

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");

        jedis.sadd("sk2","java111");
        jedis.sadd("sk2","java2");
        jedis.sadd("sk2","java3");
        jedis.sadd("sk2","java4");
        jedis.sadd("sk2","java5");

        Set<String> sk2 = jedis.smembers("sk2");
        Iterator iterator = sk2.iterator();
        while(iterator.hasNext()){
            System.out.println("set里的值：{}"+iterator.next());
        }


        jedis.zadd("zk",0,"hello0");
        jedis.zadd("zk",1,"hello1");
        jedis.zadd("zk",2,"hello2");
        jedis.zadd("zk",3,"hello3");
        jedis.zadd("zk",2.1,"hello2.1");
        jedis.zadd("zk",1.1,"hello1.1");

        Long zk = jedis.zcard("zk");
        Set<String> zk1 = jedis.zrange("zk", 0, -1);
        Iterator iteratorzk1 = zk1.iterator();
        while(iteratorzk1.hasNext()){
            System.out.println("set里的值：{}"+iteratorzk1.next());
        }

    }
}
