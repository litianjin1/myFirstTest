package com.example.study.testDemo.test;

import com.example.study.testDemo.TestUtil.CommonUseObject;
import com.example.study.facade.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {


    public static void main(String[] args) {
        String s1 = "assd,fss,fgfg";
        String[] split = s1.split("|");

        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);

//        String pattern= "[a-z,A-Z,1-9]{8}[-]{1}[a-z,A-Z,1-9]{1}";
        String pattern= "(?<=123)[a]+\\w";
        // 按指定模式在字符串查找
        String line = "123ac";
        String line2 = "1A234567-X";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        Matcher m2 = r.matcher(line2);
        boolean b = m.matches();
        boolean b2 = m2.matches();
        System.out.println("是否匹配b ："+b);
        System.out.println("是否匹配b2 ："+b2);



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


        List<User> users = Stream.of(new User("张三","1",15,new BigDecimal("1234.56"),new Timestamp(System.currentTimeMillis()),"nickname")).collect(Collectors.toList());
    }
}
