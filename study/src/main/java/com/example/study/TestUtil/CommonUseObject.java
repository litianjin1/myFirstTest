package com.example.study.TestUtil;

import com.example.study.facade.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUseObject {

    //测试用的 String 数组
    public static String[] createStringArray(){
        return new String[]{"张三","李四","王五","刘星","李天","赵六","胡八"};
    }

    //测试用的 String 二维数组
    public static String[][] createTwoStringArray(){
        String[] str1 = new String[]{"张三","李四","王五","刘星","李天","赵六","胡八"};
        String[] str2 = new String[]{"张三2","李四2","王五2","刘星2","李天2","赵六2","胡八2"};
        String[] str3 = new String[]{"张三3","李四3","王五3","刘星3","李天3","赵六3","胡八3"};
        String[] str4 = new String[]{"张三4","李四4","王五4","刘星4","李天4","赵六4","胡八4"};

        String[][] strTwoArray = new String[4][];
        strTwoArray[0] = str1;
        strTwoArray[1] = str2;
        strTwoArray[2] = str3;
        strTwoArray[3] = str4;
        return strTwoArray;
    }

    //测试用的Integer数组
    public static Integer[] createIntegerArray(){
        return new Integer[]{221,112,1,45,23,88,123,99};
    }
    //测试用的Integer数组
    public static int[] createIntArray(){
        return new int[]{221,112,1,45,23,88,123,99};
    }

    //测试用的list
    public static List<String> createListString(){
        return new ArrayList<String>(){
            {
                add("数学");
                add("语文");
                add("物理");
                add("化学");
                add("英语");
                add("地理");
                add("思想品德");
            }
        };
    }


    //方便快速生成 三十条测试数据
    public static List<User> getListUser(){

        List<User> users = new ArrayList<>();
        for(int i =0;i<=30;i++){
            User user = new User();
            user.setName("我叫"+(i));
            user.setId("id是"+i);
            user.setAge(i);
            user.setTestTime(new Timestamp(System.currentTimeMillis()+i*1000));
            user.setMoney(new BigDecimal(String.valueOf(100.2132+i*10)));
            users.add(user);
        }
        return users;
    }

    //测试用的map
    public static Map<String,String> creratMap(){
        Map<String, String> map = new HashMap<>();
        map.put("key1", "valueA");
        map.put("key2", "valueB");
        map.put("key4", "valueD");
        map.put("key5", "valueE");
        map.put("key6", "valueF");
        map.put("key3", "valueC");
        map.put("key7", "valueD");
        map.put("key8", "valueG");
        map.put("key9", "valueH");
        return map;
    }
}
