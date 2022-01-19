package com.example.study.testDemo.primaryDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class primaryDemo {
    @Autowired
    @Qualifier("pear")
    private Fruit fruit;

    public void testEat() {
        fruit.eat();
    }
}
