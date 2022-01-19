package com.example.study.testDemo.ArraysDemo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TestArrays {
    public static void main(String[] args) {
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
