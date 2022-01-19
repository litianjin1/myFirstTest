package com.example.study.facade;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Timestamp;


public class User implements Serializable,Cloneable {
    private static final long serialVersionUID = -7844477292141647011L;
    //使用@Value赋值：
//    1、基本数值
//    2、可以写spEL,#{};
//    3、可以写${ },取出配置文件里的值（在运行环境变量里的值）


    @Value("李四")
    String name;
    @Value("1")
    String id;
    @Value("#{20-3}")
    Integer age;
    BigDecimal money;
    Timestamp testTime;

    @Value("${user.nickname}")
    private String nickname;

    private Clob s;

    public User() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User(String name, String id, Integer age, BigDecimal money, Timestamp testTime) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.money = money;
        this.testTime = testTime;
    }

    public Timestamp getTestTime() {
        return testTime;
    }

    public void setTestTime(Timestamp testTime) {
        this.testTime = testTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", testTime=" + testTime +
                ", nickname='" + nickname + '\'' +
                ", s=" + s +
                '}';
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
