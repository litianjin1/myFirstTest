package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "角色权限", description = "角色分配指令权限请求对象")
public class RolePermissionReq {

    @ApiModelProperty(value = "角色id", example = "1")
    @JsonProperty("role_id")
    private int roleId;

    @ApiModelProperty(value = "权限列表", example = "[1,2,3]")
    @JsonProperty("permission_ids")
    private List<Integer> permissionIds;

}