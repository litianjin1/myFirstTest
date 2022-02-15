package com.example.study.testDemo.mysqlDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    @Autowired(required = false)
    private JdbcTemplate jdbcTemplate;

    public void insertUser(){
        String sql  = "insert into user (name,age) values (?,?)";

        jdbcTemplate.update(sql,"小明",18);
    }
}
