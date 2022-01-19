package com.example.study.facade;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MenuVO {

    public MenuVO(){
        System.out.println("MenuVO .... constructor.....");
    }
    private Integer id;

    /**
     * 上级菜单
     */
    @JsonProperty("parent_id")
    private Integer parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 菜单路由
     */
    private String path;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("update_time")
    private Date updateTime;

    /**
     * 子菜单
     */
    private List<MenuVO> children;

}