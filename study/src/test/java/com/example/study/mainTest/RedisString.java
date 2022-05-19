package com.example.study.mainTest;

import com.example.study.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisString {

    @Qualifier("redis")
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void test01(){

        String b = (String) redisTemplate.opsForValue().get("s");
        System.out.println(b);


    }


}
