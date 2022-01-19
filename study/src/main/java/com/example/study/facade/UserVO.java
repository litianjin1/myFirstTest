package com.example.study.facade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {

    private Integer id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    @JsonProperty("head_img")
    private String headImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 用户角色列表
     */
    @JsonProperty("role_list")
    private List<RoleVO> roleList;

}