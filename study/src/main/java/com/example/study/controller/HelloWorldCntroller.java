package com.example.study.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class HelloWorldCntroller {

    @GetMapping("/user")
    public String getUser(){
        return "注册中心：eureka;网关:gateway ok";
    }
//    ---------后续为了gateway来测试它，本来是要写在controller中的，这里只是为了方便测试。
}
