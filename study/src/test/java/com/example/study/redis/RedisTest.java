package com.example.study.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
        private  RedisTemplate redis;

        @Test
        public void testRedisTemplate() {
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
            // 去test里面
//            String orderNum= "F211124";
//            if(orderNum.startsWith("FR")){
//                orderNum = orderNum.substring(2);
//            }
//            System.out.println(orderNum);
//            clientStart();
            redis.opsForValue().set("template","成功了吗？");
            String s = (String) redis.opsForValue().get("template");
            System.out.println(s);
     /*
            testString();
            testList();
            testSet();*/
//            test();
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

    public  static  void test(){
        Jedis jedis = new Jedis("localhost");
        Boolean test = jedis.exists("test");
        System.out.println(test);
        if(!test){
            String set = jedis.set("test", "hello world");
           System.out.println(set);
        }
        //设置5秒后清楚test
//        jedis.expire("test",5);
        //返回test存在的剩余时间
//        System.out.println(jedis.ttl("test"));
/*        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //睡眠3秒后，test还剩下的存在时间
//        System.out.println(jedis.ttl("test"));

        //修改、获取配置信息
/*            List<String> maxclients = jedis.configGet("maxclients");
            maxclients.stream().forEach(e-> System.out.println("before maxclients:{}"+e));

            List<String> configs = jedis.configGet("*");
            configs.stream().forEach(e-> System.out.println("*{}"+e));

            jedis.configSet("maxclients","10000");
            System.out.println("after maxclients {}"+jedis.configGet("maxclients").get(1));*/

        jedis.set("s1","你好，世界111哈哈哈=萨那名单！！！");
        byte[] str1s = jedis.dump("str1");
        System.out.println("str1{}"+new String(str1s));

//        jedis.pexpireAt("str1",1555555500);

        //获得redis里所有的key
/*        Set<String> keys = jedis.keys("*");
        Iterator si = keys.iterator();
        while (si.hasNext()){
            System.out.println("si{}:"+si.next());
        }*/

        //以下字符串操作
        System.out.println("字符获取{}  "+jedis.get("s1"));
        //注意一个汉字占3个字符
        System.out.println("获得子串 {} " + jedis.getrange("s1",0,2));

        jedis.set("s2","This is my test key");
        System.out.println("s2获得子串 {} " + jedis.getrange("s2",1,2));

        //快速统计基数
        jedis.pfadd("hyperloglog","a","b","c","d","e","f");
        long hyperloglog = jedis.pfcount("hyperloglog");
        System.out.println("hyperloglog {} " + hyperloglog);

        System.out.println(" {} " + 1);
        System.out.println(" {} " + 1);
        System.out.println(" {} " + 1);
    }
}
