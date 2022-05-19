package com.example.study.testDemo.mysqlDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserMapper {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    public void insertUser(){
        String sql  = "insert into user (name,age) values (?,?)";

        String name = UUID.randomUUID().toString().replace("-","").substring(16,32);
        System.out.println("UUID.randomUUID().toString() --> "+name);
        jdbcTemplate.update(sql,name,18);
    }
}
