package com.example.study.service;

import com.example.study.projo.UserLogin;

import java.util.List;

public interface UserLoginServicesI {
    //查询
    public List<UserLogin> queryAll();
    //添加数据
    public int add(UserLogin userLogin);
    //根据用户名查询数据
    public UserLogin queryByName(String username);
}
