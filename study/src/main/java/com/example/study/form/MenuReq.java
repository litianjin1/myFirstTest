package com.example.study.form;

import com.example.study.myInterface.ApiModel;
import com.example.study.myInterface.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@ApiModel(value = "菜单", description = "菜单请求对象")
public class MenuReq {

    @ApiModelProperty(value = "菜单id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "上级菜单id", example = "-1", required = true)
    @JsonProperty(value = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "菜单名称", example = "AdminManager", required = true)
    private String name;

    @ApiModelProperty(value = "菜单URL", example = "Layout", required = true)
    private String url;

    @ApiModelProperty(value = "菜单路由", example = "/admin", required = true)
    private String path;

    @ApiModelProperty(value = "菜单标题", example = "后台管理", required = true)
    private String title;

    @ApiModelProperty(value = "菜单图标", example = "lock")
    private String icon;

    @ApiModelProperty(value = "排序", example = "1", required = true)
    private Integer sort;

}