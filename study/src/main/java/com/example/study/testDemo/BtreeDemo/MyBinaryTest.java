package com.example.study.testDemo.BtreeDemo;

public class MyBinaryTest {
    public static void main(String[] args) {
        deleteTest();
        testPre();
        testPrePro();
        testCenter();
        testCenterPro();
        testAfter();
        testAfterPro();
    }

    public static void deleteTest() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        System.out.println("是否存在28："+tree.isContainNode(28));
        tree.deleteNode(28);
        System.out.println("删除28后是否还存在28："+tree.isContainNode(28));
    }

    public static void testCenter() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.centerShow();
    }

    public static void testCenterPro() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.centerShowPro();
    }

    public static void testPre() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.preShow();
    }

    public static void testPrePro() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.preShowPro();
    }

    public static void testAfter() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.afterShow();
    }

    public static void testAfterPro() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(28);
        tree.addNode(50);
        tree.addNode(38);
        tree.addNode(58);
        tree.afterShowPro();
    }

}
