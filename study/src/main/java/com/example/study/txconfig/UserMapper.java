package com.example.study.txconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(){
        String sql  = "insert into user (name,age) values (?,?)";

        jdbcTemplate.update(sql,"小明",18);
    }
}
