package com.example.study;

import com.example.study.testDemo.controller.HelloWorldCntroller;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootTest
class StudyApplicationTests {


    @Test
    void contextLoads() {

    }

    @Test
    void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HelloWorldCntroller h = new HelloWorldCntroller();
        h.getUser("测试单元",request,response);
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
