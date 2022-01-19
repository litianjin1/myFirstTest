package com.example.study.testDemo.controller;

import com.example.study.testDemo.aspectDemo.AspectInteface;
import com.example.study.facade.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Api
@RestController
@RequestMapping("/hello")
@PropertySource({"classpath:/pro.properties"})
public class HelloWorldCntroller {

    @Value("${book.name}")
    public String bookvalue;

    @PostConstruct
    public void init(){
        System.out.println("bookvalue {}"+bookvalue);
    }

    @ApiOperation(value = "hello world 接口")
    @GetMapping("/user")
    @AspectInteface(title = "hello 世界！！！！")
    public String getUser(@RequestParam(value = "str") String str){
        System.out.println("打印hello啊啊啊啊222{}"+str +"  bookvalue"+bookvalue);
        return "注册中心：eureka;网关:gateway ok {} " +str;
    }
//    ---------后续为了gateway来测试它，本来是要写在controller中的，这里只是为了方便测试。


    public String testModel(@ModelAttribute("s") User user){
        return "success";

    }
}
