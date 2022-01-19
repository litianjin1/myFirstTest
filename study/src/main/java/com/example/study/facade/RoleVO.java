package com.example.study.facade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RoleVO {

    private Integer id;

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名
     */
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("update_time")
    private Date updateTime;

    /**
     * 每个角色分配的菜单权限
     */
    @JsonProperty("menu_list")
    private List<MenuVO> menuList;

    /**
     * 每个角色分配的指令权限
     */
    @JsonProperty("permission_list")
    private List<PermissionVO> permissionList;

}