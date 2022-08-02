package com.example.study.testDemo.lambdaDemo;

import com.example.study.facade.Car;
import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalTest {


    @Test
    public void test01(){

        Optional<Car> car = Optional.of(new Car());
        System.out.println(car.get());


        Optional<Car> empty = Optional.empty();

        Car car1 = empty.orElse(new Car("小汽车", 10100.1, 2));

        Car kkk = empty.orElseGet(() -> {
            return new Car("kkk", 1010.0, 8);
        });

        System.out.println(car1.toString());
        System.out.println(kkk.toString());

        if(empty.isPresent()){
            System.out.println(empty.get());
        }else{
            System.out.println("aaaaaa");

        }


    }
}
