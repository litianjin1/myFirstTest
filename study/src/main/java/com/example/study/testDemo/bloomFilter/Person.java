package com.example.study.testDemo.bloomFilter;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Person {
    private Long id;
    private String name;//姓名
    private Long phone;//电话
    private BigDecimal salary;//薪水
    private String company;//公司
    private Integer ifSingle;//是否单身
    private Integer sex;//性别
    private String address;//住址
    private LocalDateTime createTime;
    private String createUser;
}
