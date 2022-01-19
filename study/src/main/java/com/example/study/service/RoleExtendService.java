package com.example.study.service;

public interface RoleExtendService extends RoleService {

    String name = "必须要有默认值";

    default void goodDefault(){
        System.out.println("sss");
    }
}
