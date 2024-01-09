package com.example.study.testDemo.ArraysDemo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class TestArrays {
    public static void main(String[] args) {
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙的线程~");
        });

        for (int i=1;i<=7;i++){
            int atI = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" 收集了第" + atI +"颗龙珠");
                    cyclicBarrier.await(); //加法计数 等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }

        Integer[] a = new Integer[5];
        Integer[] b={16,9,11,21,3,4,5,6};
        Arrays.fill(a ,5);
        System.out.println(Arrays.toString(a));
        List ints = Arrays.asList(b);

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        System.out.println(Arrays.equals(a,b));

        String join = StringUtils.join(ints, '.');
        System.out.println(join);

        Integer[] copyOf = Arrays.copyOf(b, 10);
        List<Integer> list = Arrays.asList(copyOf);
        System.out.println(list);

    }
}
