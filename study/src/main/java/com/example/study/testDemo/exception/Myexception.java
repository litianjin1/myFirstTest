package com.example.study.testDemo.exception;

public class Myexception extends Exception {
    private String name;
    private String money;

    public Myexception(String name, String money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }
}
