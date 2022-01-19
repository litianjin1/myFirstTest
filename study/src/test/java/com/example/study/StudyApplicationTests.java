package com.example.study;

import com.example.study.testDemo.controller.HelloWorldCntroller;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class StudyApplicationTests {


    @Test
    void contextLoads() {

    }

    @Test
    void test1(){

        HelloWorldCntroller h = new HelloWorldCntroller();
        h.getUser("测试单元");
    }
    @Resource
    private RedisTemplate redis;

    @Test
    public void testRedisTemplate() {
        redis.opsForValue().set("template","成功了吗？");
        String s = (String) redis.opsForValue().get("template");
        System.out.println(s);

    }
}
