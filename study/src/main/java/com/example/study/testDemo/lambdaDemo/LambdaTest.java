package com.example.study.testDemo.lambdaDemo;

import com.example.study.facade.Car;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    @Test
    public  void test() {
        //1、消费型，没有返回值。有参数
        Consumer<Integer> consumer = (e) -> {
            System.out.println(e);
            Integer num = e+1000;
            System.out.println(num);
        };
        consumer.accept(899);

        //2、供给型，有返回值,无参数
        Supplier<Car> supplier = () -> new Car();
        Car car = supplier.get();
        System.out.println(car);

        //3、函数型
        Function<Integer,String> function = (e) ->{
            System.out.println("Function ......"+e);

          return e+"次呀！！！";
        };

        String apply = function.apply(1000);
        System.out.println(apply);

        //断言型，接收参数，返回 布尔值
        Predicate<Integer> predicate = (e) ->{
            if(e>1000){
                return true;
            }
            return  false;
        };
        boolean test = predicate.test(999);
        System.out.println(test);

        Add add =(int a,int b)->a+b;


    }
}
