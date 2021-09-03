package com.example.study.test;

import com.example.study.enums.MyEnum;

public class TestEnum {
    public static void main(String[] args) {
        MyEnum e = MyEnum.BLUE;
        System.out.println(MyEnum.getColor(2));
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
