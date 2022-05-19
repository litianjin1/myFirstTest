package com.example.study.config;


import com.example.study.facade.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * profile : 可以根据当前环境切换一系列组件的功能。
 * @Profile ：指定组件在哪个环境下才能被注册到容器里，不指定，任何环境下都能注册这个组件。
 *      1、加了环境标识的bean,只有这个环境激活的时候才能注册到容器里，默认是default环境。
 *      2、写在配置类上，只有是指定环境，整个配置类的所有配置才能生效
 *
 *
 *
 * 本demo使用三种方式注入参数 ：
 *                  1、@PropertySource("classpath:/dbconfig.properties")  和    @Value("${db.user}")
 *                  2、 EmbeddedValueResolverAware 接口， 重写 setEmbeddedValueResolver ，定义 StringValueResolver，
 *                  调用  valueResolver.resolveStringValue("${db.driverClass}");；
 */
//@Configuration
@PropertySource("classpath:/dbconfig.properties")
//@Profile("test")
public class MainConfigProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

//    @Profile("test")
/*    @Bean("user")
    public User user(){
        return new User();
    }*/


    @Profile("test")
    @Bean("testDatasource")
    public DataSource dataSourceTest(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/my_test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Profile("dev")
    @Bean("devDatasource")
    public DataSource dataSourceDev(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/my_test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDatasource")
    public DataSource dataSourceProd(@Value("${db.password}") String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/my_test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        this.valueResolver= resolver;
        String driverClass = valueResolver.resolveStringValue("${db.driverClass}");

        this.driverClass= driverClass;
    }
}
