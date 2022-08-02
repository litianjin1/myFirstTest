package com.example.study.facade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Timestamp;

//@ConfigurationProperties(prefix = "")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable,Cloneable {
    private static final long serialVersionUID = -7844477292141647011L;
    //使用@Value赋值：
//    1、基本数值
//    2、可以写spEL,#{};
//    3、可以写${ },取出配置文件里的值（在运行环境变量里的值）


    @Value("李四")
    public String name;
    @Value("1")
    String id;
    @Value("#{20-3}")
   public Integer age;
    BigDecimal money;
    Timestamp testTime;

    @Value("${user.nickname}")
    private String nickname;

//    private Clob s;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
