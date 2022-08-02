package com.example.study.facade;

import com.alanpoi.analysis.common.enums.AlanColor;
import com.alanpoi.analysis.excel.annotation.DateFormat;
import com.alanpoi.analysis.excel.annotation.ExcelColumn;
import com.alanpoi.analysis.excel.annotation.ExcelSheet;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 地区表 districts
 * 
 * @author ruoyi
 * @date 2018-12-19
 */
@Data
@ExcelSheet(name = "测试", backColor = AlanColor.GREEN, font = "宋体", fontSize = 25)
public class Districts
{
    private static final long serialVersionUID = 1L;

    private  Integer rowIndex;
    /** 编号 */
    @ExcelColumn(name = "编号",color = AlanColor.RED)
    private Integer  id;

    /** 上级编号 */
    @ExcelColumn(name = "上级编号")
    private Integer  pid;

    /** 层级 */
    @ExcelColumn(name = "层级")
    private Integer           deep;

    /** 名称 */
    @ExcelColumn(name = "名称")
    private String            name;

    /** 上级名称 */
    @ExcelColumn(name = "上级名称")
    private String            pname;

    /** 拼音 */
    @ExcelColumn(name = "拼音")
    private String            pinyin;

    /** 拼音缩写 */
    @ExcelColumn(name = "拼音缩写")
    private String            pinyinShor;

    /** 扩展名 */
    @ExcelColumn(name = "扩展名")
    private String            extName;

    /** 操作人 */
    @ExcelColumn(name = "操作人")
    private String            operator;

    @ExcelColumn(name = "插入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    @DateFormat(value = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")    @DateFormat(value = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
