package com.example.study.testDemo.controller;

import com.example.study.facade.User;
import com.example.study.testDemo.aspectDemo.AspectInteface;
import com.example.study.testDemo.listenerModel.listenerEvent.event.MyEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Api
@Slf4j
@RestController
@RequestMapping("/test")
@PropertySource({"classpath:/pro.properties"})
public class TestController {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @GetMapping("/info")
    public String getUser(@RequestParam(value = "str") String str){
        redisTemplate.opsForValue().set("s","sssss");
        Object s = redisTemplate.opsForValue().get("s");
         redisTemplate.opsForValue().increment("viewNum");
        //加上@Async注解，可以开启异步事件，多线程处理 ；否则默认同步阻塞处理事件的
        for (int i = 0; i < 5; i++) {
            applicationContext.publishEvent(new MyEvent(this,"第"+i+"次， 你啊飒飒好啊啊！！！"));

        }
        applicationContext.publishEvent(new MyEvent(this,"你好世界！！！"));

        redisTemplate.opsForValue().decrement("viewNum",11);

        String name = redisTemplate.opsForValue().get("name", 3, 5);
        List<Object> objects = redisTemplate.opsForValue().multiGet(new ArrayList<String>() {{
            add("name");
            add("viewNum");
        }});
        Object viewNum = redisTemplate.opsForValue().get("viewNum");
        return "收到:"+str +" 访问查看次数 ："+viewNum +" ; 截取："+name;
    }


    @GetMapping("/redisList")
    public void redisList(@RequestParam(value = "str") String key,HttpServletRequest request,HttpServletResponse response) throws Exception{
        redisTemplate.opsForValue().setIfAbsent("viewListNum",0);
        redisTemplate.opsForValue().increment("viewListNum");
        //加上@Async注解，可以开启异步事件，多线程处理 ；否则默认同步阻塞处理事件的
        for (int i = 0; i < 5; i++) {
            applicationContext.publishEvent(new MyEvent(this,"第"+i+"次， 测试redis 的list类型数据！！！"));

        }
        applicationContext.publishEvent(new MyEvent(this,"时间发布 ， 你好世界！！！"));
        redisTemplate.opsForList().leftPush("list1","mm1");
        redisTemplate.opsForList().leftPush("list1","mm2");
        redisTemplate.opsForList().leftPush("list1","mm3");
        redisTemplate.opsForList().leftPush("list1","mm4");
        redisTemplate.opsForList().leftPush("list1","mm5");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取请求行的相关信息
        Object viewNum = redisTemplate.opsForValue().get("viewListNum");

        out.println("访问参数 ："+key +"  | 访问次数："+viewNum+"<br>");
        out.println("HttpServletRequest对象获取请求行信息方法示例：<br>");
        out.println("getMethod : " + request.getMethod() + "<br>");
        out.println("getRequestURI : " + request.getRequestURI() + "<br>");
        out.println("getQueryString:" + request.getQueryString() + "<br>");
        out.println("getProtocol : " + request.getProtocol() + "<br>");
        out.println("getContextPath:" + request.getContextPath() + "<br>");
        out.println("getServletPath : " + request.getServletPath() + "<br>");
        out.println("getRemoteAddr : " + request.getRemoteAddr() + "<br>");
        out.println("getRemoteHost : " + request.getRemoteHost() + "<br>");
        out.println("getRemotePort : " + request.getRemotePort() + "<br>");
        out.println("getLocalAddr : " + request.getLocalAddr() + "<br>");
        out.println("getLocalName : " + request.getLocalName() + "<br>");
        out.println("getLocalPort : " + request.getLocalPort() + "<br>");
        out.println("getServerName : " + request.getServerName() + "<br>");
        out.println("getServerPort : " + request.getServerPort() + "<br>");
        out.println("getScheme : " + request.getScheme() + "<br>");
        out.println("getRequestURL : " + request.getRequestURL() + "<br>");


        Collection<Object> list = redisTemplate.opsForList().range(key, 0, -1);
        list.forEach((e)->  out.println("redisList => key : "+ key+" | value:"+ e + "<br>"));

//        return "收到:"+key +" 访问查看redisList次数 ："+viewNum ;
    }

}
