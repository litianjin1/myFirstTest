package com.example.study.testDemo.test;

import com.example.study.testDemo.exception.Myexception;

public class TestException {

    public static void main(String[] args) {
        try {
            test();
        } catch (Myexception myexception) {
            System.out.println(myexception.getMoney());
            System.out.println(myexception.getName());
            System.out.println(myexception.getMessage());
            System.out.println(myexception.getCause());
            myexception.printStackTrace();
        }
    }

    public  static void test() throws Myexception{
        throw  new Myexception("hello","金钱","金钱转化错误" );
    }
}
