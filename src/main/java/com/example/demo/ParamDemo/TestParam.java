package com.example.demo.ParamDemo;

import com.example.demo.facade.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestParam {
    public static void swap(Integer i, Integer j) {
        Integer temp = new Integer(i);
        i = j;
        j = temp;
    }
    public static void main(String[] args) {
        System.out.println(fun(0));
        testClone( );
        testLishi(new LinkedList());
        Integer i = new Integer(1110);
        Integer j = new Integer(2220);
        swap(i, j);
        System.out.println("i = " + i + ", j = " + j);
    }

    static int fun(int x )
    {
        return x;
    }

    static void testClone( )
    {
        User user1 =new User();
        user1.setName("aaaa");
        User user2;
        try {
            user2= user1.clone();
            user2.setName("hhhh");
            System.out.println(user1.toString());
            System.out.println(user2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 里氏替换原则 ： 引用基类（父类）的地方必须能透明地使用其子类的对象。
     */
    static void testLishi(List list){
        list.add("qqqq");
        list.add("aaa");
    }
}
