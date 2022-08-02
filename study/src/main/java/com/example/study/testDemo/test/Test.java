package com.example.study.testDemo.test;

import java.text.NumberFormat;
import java.util.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {
      /*  byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3=(b1+b2);
        System.out.println(b3+b6);*/

      //上界
        List<? extends Father> list1 = new ArrayList<Father>();
        List<? extends Father> list2 = new ArrayList<Son>();
        List<? extends Father> list3 = new ArrayList<LeiFeng>();
/*        list1.add(new Son());
        list1.add(new Father());*/
        Father father = list1.get(0);//读取出来的东西只能存放在Father或它的基类里。
        Object object = list1.get(0);//读取出来的东西只能存放在Father或它的基类里。
        Human human = list1.get(0);//读取出来的东西只能存放在Father或它的基类里。

        //下届
        List<? super Father> list = new ArrayList<>();
        list.add(new Father());
//        list.add(new Human());//compile error
        list.add(new Son());
//        Father person1 = list.get(0);//compile error
//        Son son = list.get(0);//compile error
        Object object1 = list.get(0);
    }

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        return max;
    }
}


class Human{
}
class Father extends Human{
}
class Son extends Father{
}
class LeiFeng extends Father {
}





