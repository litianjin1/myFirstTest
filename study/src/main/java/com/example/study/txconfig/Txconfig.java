package com.example.study.txconfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *  环境搭建：
 *  1、导入相关依赖
 *      数据源、数据库驱动、spring-jdbc模块
 *  2、配置数据源、jdbcTemplate(Spring提供的简化数据库操作的工具)
 *  3、给方法上加上@Transactional 表示当前方法为一个事务方法
 *  4、配置类上加上 @EnableTransactionalManagement 开始基于注解的事务管理功能
 *  5、配置事务管理器加载到容器里 PlatformTransactionManager
 *     @Bean
 *     public PlatformTransactionManager transactionManager() throws Exception {
 */
@ComponentScan("com.example.study.txconfig")
@Configuration
@PropertySource("classpath:/dbconfig.properties")
@EnableTransactionManagement
public class Txconfig {

    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private  String password;
    @Value("${db.driverClass}")
    private String driverClass;
    @Value("${db.jdbcUrl}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        //spring 对 config ration类会特殊处理，第一个创建到容器里，多次调用，都只是从容器里找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return  new DataSourceTransactionManager(dataSource());
    }
}
