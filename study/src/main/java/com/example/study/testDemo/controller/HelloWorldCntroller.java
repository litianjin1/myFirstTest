package com.example.study.testDemo.controller;

import com.example.study.testDemo.aspectDemo.AspectInteface;
import com.example.study.facade.User;
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

@Api
@Slf4j
@RestController
@RequestMapping("/hello")
@PropertySource({"classpath:/pro.properties"})
public class HelloWorldCntroller {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @GetMapping("/info")
    public String getUser(@RequestParam(value = "str") String str){
//        Object s = redisTemplate.opsForValue().get("s");
        //加上@Async注解，可以开启异步事件，多线程处理 ；否则默认同步阻塞处理事件的
        for (int i = 0; i < 5; i++) {
            applicationContext.publishEvent(new MyEvent(this,"第"+i+"次， 你啊飒飒好啊啊！！！"));

        }
        applicationContext.publishEvent(new MyEvent(this,"你好世界！！！"));
        return "收到:";
    }

    @Value("${book.name}")
    public String bookvalue;

    @PostConstruct
    public void init(){
        System.out.println("bookvalue {}"+bookvalue);
    }



    @ApiOperation(value = "hello world 接口")
    @GetMapping("/user")
    @AspectInteface(title = "hello 世界！！！！")
    public void getUser(@RequestParam(value = "str") String str, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("@Slf4j");
        System.out.println("打印hello啊啊啊啊222{}"+str +"  bookvalue"+bookvalue);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取请求行的相关信息
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

        out.println("注册中心：eureka;网关:gateway ok {} " +str); ;
    }
//    ---------后续为了gateway来测试它，本来是要写在controller中的，这里只是为了方便测试。


    public String testModel(@ModelAttribute("s") User user){
        return "success";

    }
}
