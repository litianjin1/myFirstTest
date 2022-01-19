package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "角色", description = "角色请求对象")
public class RoleReq {

    @ApiModelProperty(value = "角色id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "角色编码", example = "admin", required = true)
    private String code;

    @ApiModelProperty(value = "角色名称", example = "管理员", required = true)
    private String name;

}
