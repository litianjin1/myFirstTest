package com.example.study.testDemo.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestXunhuan {

    @Test
    public void test()  throws  Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text.");
        while (true){
            String s = bufferedReader.readLine();
            if("q".equals(s)){
               break;
            }
            System.out.println(bufferedReader.readLine());
        }
    }


    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter lines of text.");
            while (true){
                String s = bufferedReader.readLine();
                if("q".equals(s)){
                    System.out.println("quit!!!");
                    break;
                }
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("asaas");
        }
    }

}
