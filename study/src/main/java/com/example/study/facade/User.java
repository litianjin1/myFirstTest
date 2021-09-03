package com.example.study.facade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


public class User implements Serializable,Cloneable {
    private static final long serialVersionUID = -7844477292141647011L;
    String name;
    String id;
    Integer age;
    BigDecimal money;
    Timestamp testTime;

    public User() {
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
                "name='"+name+"'" +
                ",age="+age+"" +
                ",testTime="+testTime+"" +
                ",money="+money+"}";
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
