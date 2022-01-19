package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "用户角色", description = "用户分配角色请求对象")
public class UserRoleReq {

    @ApiModelProperty(value = "用户id", example = "1")
    @JsonProperty("user_id")
    private int userId;

    @ApiModelProperty(value = "角色列表", example = "[1,2]")
    @JsonProperty("role_ids")
    private List<Integer> roleIds;

}
