package com.example.study.test;

import com.example.study.TestUtil.CommonUseObject;
import com.example.study.facade.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {

    public static void main(String[] args) {
        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("t1", "1");
        hashtable.put("t2", "2");
        hashtable.put("t3", "3");

        Enumeration<Map.Entry<String, String>> iterator1 = (Enumeration<Map.Entry<String, String>>) hashtable.entrySet().iterator();
        hashtable.remove(iterator1.nextElement().getKey());
        while (iterator1.hasMoreElements()) {
            System.out.println(iterator1.nextElement());
        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("h1", "1");
        hashMap.put("h2", "2");
        hashMap.put("h3", "3");

        Iterator<Map.Entry<String, String>> iterator2 = hashMap.entrySet().iterator();
        hashMap.remove(iterator2.next().getKey());
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        List<User> userList = CommonUseObject.getListUser();
        for(User u :userList){
            u.setName("a");
        }
        userList.stream().forEach(e->System.out.println(e.getName()));

        List<User> arrayList = new ArrayList<User>(){{
                add(new User());
        }};


        List<User> users = Stream.of(new User("张三","1",15,new BigDecimal("1234.56"),new Timestamp(System.currentTimeMillis()))).collect(Collectors.toList());
    }
}
