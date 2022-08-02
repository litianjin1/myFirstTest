package com.example.study;

import com.example.study.mapper.UserLoginMapper;
import com.example.study.projo.UserLogin;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@MapperScan(value = "com.example.study.mapper")
class Weixin01ApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("数据库链接。。。。。。。。。。。。。。。。。");
        System.out.println(connection);

        //template模板，拿来即用
        connection.close();
    }
    @Autowired
    UserLoginMapper userLoginMapper;
    @Test
    public void toTest(){
        List<UserLogin> userLogins = userLoginMapper.queryAll();
        userLogins.forEach(e-> System.out.println(e));
    }
}
