package com.example.demo.page1;

import com.example.demo.TestUtil.CommonUseObject;
import com.example.demo.facade.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//测试 分页插件

@RequestMapping("/myTest")
@RestController
public class TestPageHelper {

    @GetMapping("/getUserList")
    public PageInfo<User> getUserList(){
        PageHelper.startPage(1,15);
        PageInfo<User> userPageInfo =new PageInfo<>(CommonUseObject.getListUser());
        return userPageInfo;
    }


    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for(int i =0;i<=30;i++){
            User user = new User();
            user.setName("name:"+(i));
            user.setId("id:"+i);
            user.setAge(i);
            int s =new Random().nextInt()*1000;
            System.out.println(i+":"+s);
            user.setTestTime(new Timestamp(System.currentTimeMillis()+ s));
            users.add(user);
        }

        //stream流 ，排序，跳过前十个，限制取5个，接手list
       List<User> newList =  users.stream().sorted((o1, o2) -> {
            return Long.compare(o1.getTestTime().getTime(), o2.getTestTime().getTime() * -1);
        }).skip(10).limit(5).collect(Collectors.toList());

        //foreach 遍历
        newList.forEach((e)-> System.out.println("shijian:"+e.getTestTime()));
    }



    /**
     *
     * @description
     * @author ltj
     * @date 2021/7/1 20:50
     * @param ss
     * @param saaa
     * @return java.lang.String
     */
    private String ssss(String ss,Integer saaa){
        return  "ss";
    }
}
