package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "指令权限", description = "权限请求对象")
public class PermissionReq {

    @ApiModelProperty(value = "权限id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "指令权限", example = "user-center:user:saveOrUpdate", required = true)
    private String permission;

    @ApiModelProperty(value = "权限名称", example = "用户新增或修改", required = true)
    private String name;

}