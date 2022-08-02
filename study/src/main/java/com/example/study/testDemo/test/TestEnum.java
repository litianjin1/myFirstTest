package com.example.study.testDemo.test;

import com.example.study.testDemo.enums.MyEnum;

public class TestEnum {
    public static void main(String[] args) {
        MyEnum red = MyEnum.valueOf("RED");
        System.out.println(red.toString());
        System.out.println("\n\n");

        System.out.println(MyEnum.getColor(2));
        System.out.println("\n\n");

        MyEnum e = MyEnum.BLUE;
        System.out.println(e.toString());
        System.out.println("\n\n");
        for(MyEnum s:MyEnum.values()){
            System.out.println(s+"\t"+s.ordinal());
        }
    }

class Innenr{

}

class  test{

}

}
