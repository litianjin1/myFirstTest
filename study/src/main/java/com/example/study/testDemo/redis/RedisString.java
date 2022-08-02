package com.example.study.testDemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;


@Component
public class RedisString {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test01(){

        String b = (String) redisTemplate.opsForValue().get("s");
        System.out.println(b);


    }


}
