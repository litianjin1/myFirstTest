/**
 * @Project: springboot-mybatis
 * @Title: JavamelodyConfiguration.java
 * @Package: com.xncoding.pos.config
 * @Description: TODO
 * @author: QIJJ
 * @since: 2018年6月21日 上午11:25:59
 * @Copyright: 2018. All rights reserved.
 * @Version: v1.0
 */
package com.example.study.util.config;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JavamelodyConfiguration
 * @Description: JavaMelody 监控
 * @author: fengnx
 * @since: 2018年6月21日 上午11:25:59
 */
@Configuration
public class JavamelodyConfiguration {

    @Bean
    public FilterRegistrationBean<MonitoringFilter> monitorFilter() {
        FilterRegistrationBean<MonitoringFilter> filterRegistrationBean = new FilterRegistrationBean<MonitoringFilter>(new MonitoringFilter());
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListener() {
        ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<SessionListener>();
        servletListenerRegistrationBean.setListener(new SessionListener());

        return servletListenerRegistrationBean;
    }

}
