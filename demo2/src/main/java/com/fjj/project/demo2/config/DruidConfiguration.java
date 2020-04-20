package com.fjj.project.demo2.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: fengjiajia
 * @Date: 2020/4/16
 * @Description: durid
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean statViewServle() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //IP白名单
        //servletRegistrationBean.addInitParameter("allow", "127.0.0.1, 127.0.0.1");
        //IP黑名单
        //servletRegistrationBean.addInitParameter("deny", "127.0.0.1, 127.0.0.1");
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "12345678");
        //是否允许重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.jpg, *.png, *.css, /druid/*");
        return filterRegistrationBean;
    }
}
