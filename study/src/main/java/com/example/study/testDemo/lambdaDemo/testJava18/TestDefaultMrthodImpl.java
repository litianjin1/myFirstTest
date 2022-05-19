package com.example.study.testDemo.lambdaDemo.testJava18;


import org.junit.Test;

public class TestDefaultMrthodImpl implements TestDefaultMethod {


    @Override
    public void run() {
        System.out.println("跑步中。。。。");
    }

    @Override
    public void action() {
        System.out.println("正在做什么动作呢。。。。。。 ");
    }



    @Test
    public void testExample(){
        TestDefaultMrthodImpl tdf = new TestDefaultMrthodImpl();

        tdf.eat();
        tdf.play();
        tdf.run();
        tdf.action();
    }
}
