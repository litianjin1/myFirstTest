package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "角色菜单", description = "角色分配菜单请求对象")
public class RoleMenuReq {

    @ApiModelProperty(value = "角色id", example = "1")
    @JsonProperty("role_id")
    private int roleId;

    @ApiModelProperty(value = "菜单列表", example = "[1,2,3]")
    @JsonProperty("menu_ids")
    private List<Integer> menuIds;

}