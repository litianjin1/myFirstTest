package com.example.study.facade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PermissionVO {

    private Integer id;

    /**
     * 指令权限
     */
    private String permission;

    /**
     * 权限名称
     */
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("update_time")
    private Date updateTime;

}