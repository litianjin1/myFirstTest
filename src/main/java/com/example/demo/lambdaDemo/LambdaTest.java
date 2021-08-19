package com.example.demo.lambdaDemo;

public class LambdaTest {



    interface Add {
        int numadd(int a,int b);
    }

    /*
     *
     * @description
     * @author ltj
     * @date 2021/8/10 11:40
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        Add add =(int a,int b)->a+b;


    }
}
