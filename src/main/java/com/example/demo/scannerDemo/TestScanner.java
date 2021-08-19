package com.example.demo.scannerDemo;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        System.out.println("请输入！！！");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
