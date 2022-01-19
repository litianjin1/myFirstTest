package com.example.study.txconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insertUser(){
        userMapper.insertUser();
        System.out.println("插入完成。。。。。");
        int i= 10/0;
    }
}
