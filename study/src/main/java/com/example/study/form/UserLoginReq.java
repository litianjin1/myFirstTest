package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户登录", description = "用户登录请求对象")
public class UserLoginReq {

    @ApiModelProperty(value = "用户名", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", example = "123456")
    private String password;

    @ApiModelProperty(value = "验证码", example = "123456")
    private String captcha;

}