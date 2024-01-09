package com.example.study.testDemo.lambdaDemo;

import com.example.study.facade.Car;
import org.docx4j.wml.P;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

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

        String s = "XPsa22";
        String substring = s.substring(2);
        System.out.println(substring);
        Integer[] integers = {12,54,63,47,85,5,96,54};
        List<Integer> list = Arrays.asList(integers);
        list.forEach((e) -> {
            System.out.println(e);
            System.out.println("=====================");
        });

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

        //3、函数型 有参数，有返回值
        Function<Integer,String> function = (e) ->{
            System.out.println("Function ......"+e);

          return e+"次呀！！！";
        };

        String apply = function.apply(1000);
        System.out.println(apply);

        //断言型，接收参数，返回 布尔值
       Predicate<Integer> predicate = (e) ->{
            /* if(e>1000){
                return true;
            }
            return  false;*/
            return e>1000;
        };
        boolean test = predicate.test(999);
        System.out.println(test);

        Add add =(int a,int b)->a+b;
        Add add1 =( a, b)->a+b;


    }
}
