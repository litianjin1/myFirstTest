package com.example.demo.page1;

import com.example.demo.TestUtil.CommonUseObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysUse {


    public static void main(String[] args) {
        testAraays();
    }

    public static  void testAraays(){
        //1111数组转字符串
        String[] strings = CommonUseObject.createStringArray();
        String[][] stringsT = CommonUseObject.createTwoStringArray();
        System.out.println("使用Arrays方式toString:   "+Arrays.toString(strings));
        System.out.println("使用Arrays方式(针对多多维数组)deepToString:   "+Arrays.deepToString(stringsT));
        System.out.println("数组直接tostring:   "+strings.toString());

        //2222填充数组
        int [] array = new int[5];
        Arrays.fill(array, 2);
        System.out.println(Arrays.toString(array)); //[2, 2, 2, 2, 2]

        array = new int[5];
        Arrays.fill(array, 4, 5, 2); //部分填充
        System.out.println(Arrays.toString(array));//[0, 2, 2, 2, 0]

        //3333数组元素排序
        array = CommonUseObject.createIntArray();
        Arrays.sort(array);
        System.out.println("sort排序:"+Arrays.toString(array)); //[0, 2, 3, 4, 10]

        array = CommonUseObject.createIntArray();
        Arrays.parallelSort(array); //和sort相比是这个是并行的
        System.out.println("和sort相比是这个是并行的:"+Arrays.toString(array)); //[0, 2, 3, 4, 10]

        array = CommonUseObject.createIntArray();
        Arrays.sort(array, 0, 3); //部分排序
        System.out.println("和sort相比是这个是部分排序的:"+Arrays.toString(array)); //[0, 3, 4, 10, 2]


//        44444数组的比较
        int[] array2 = new int[]{1, 2, 3};
        System.out.println("数组的比较: "+Arrays.equals(array, array2)); //true
         /*
         deepEquals用于判定两个指定数组彼此是否深层相等，此方法适用于任意深度的嵌套数组。
         equals用于判定两个数组是否相等，如果两个数组以相同顺序包含相同元素，则返回true。
         如果两个数组使用equals返回true，则使用deepEquals必定也返回true，也就是说在比较的两个数组均为一维数组的前提下，equals和deepEquals的比较结果没有差别。
        */


        //55555数组复制
        int[] arrayCopy = Arrays.copyOf(array, 3);
        System.out.println("数组复制,指定复制的长度: "+Arrays.toString(arrayCopy)); //[3, 10, 4]

        arrayCopy = Arrays.copyOf(array, 11);
        System.out.println("数组复制,多出的长度补0 :"+Arrays.toString(arrayCopy)); //[3, 10, 4, 0, 2, 0, 0], 多出的长度补0

        arrayCopy = Arrays.copyOfRange(array, 1, 4);
        System.out.println("数组复制,截取指定范围的："+Arrays.toString(arrayCopy)); //[10, 4, 0]

        //66666数组转List
        List list = Arrays.asList(array);


        //77777对数组元素采用指定的方法计算
        array = new int[]{3, 10, 4, 0, 2,12,45,0,1};
        //x代表数组中前一个索引处的元素，计算第一个元素时，x为1
        //y代表数组中当前索引处的元素
        Arrays.parallelPrefix(array, (x,y)->(x+y)); //[3, 13, 17, 17, 19]
        System.out.println("对数组元素采用指定的方法计算parallelPrefix: "+Arrays.toString(array));

        array = new int[]{3, 10, 4, 0, 2};
        //注意：x代表正在计算的元素的索引
        Arrays.parallelSetAll(array, (x)->(x*x)); //[0, 1, 4, 9, 16]
        System.out.println("对数组元素采用指定的方法计算 parallelSetAll: "+Arrays.toString(array));

        int s = 10%3;
        int a = 10/3;
        System.out.println(s+"  |||  "+a);
        //注意：x代表正在计算的元素的索引
        Arrays.setAll(array, (x)->(x%3));
        System.out.println("对数组元素采用指定的方法计算 setAll: "+Arrays.toString(array)); //[0, 1, 2, 0, 1], 与parallelSetAll相比只是不并行


        //88888自定义排序规则
        // Arrays.sort方法和Collections.sort方法都提供了一个可以接收Comparator实例作为第二个参数的版本。
/*        public class LengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
            public static void main(String[] args){
                String[] names = {"tom", "alice", "fred"};
                Arrays.sort(names, new LengthComparator());
                out.println(Arrays.toString(names));
            }
        }*/

        //要按照长度比较字符串，定义一个实现Comparator<String>的类。因为comparetor 只有一个方法compare，可以使用lambda代替
        String[] names = {"tom", "alice", "fred","s"};
        Comparator<String> comp = (first, second) -> first.length() - second.length();
        Arrays.sort(names, comp);
        System.out.println("自定义排序："+ Arrays.toString(names));

        //或者更加简单点
        String[] names2 = {"tom", "alice", "fred"};
        Arrays.sort(names2, (first, second) -> first.length() - second.length());

        System.out.println("自定义排序,lambda方式："+ Arrays.toString(names2));
    }
}
