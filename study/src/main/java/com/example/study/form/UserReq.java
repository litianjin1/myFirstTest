package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户", description = "用户请求对象")
public class UserReq {

    @ApiModelProperty(value = "用户id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    private String username;

    @ApiModelProperty(value = "昵称", example = "管理员", required = true)
    private String nickname;

}