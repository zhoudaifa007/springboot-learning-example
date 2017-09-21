package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.spring.springboot.dao.CityDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("org.spring.springboot.dao")
@ImportResource(locations={"classpath:application-bean.xml"})
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }

    @Bean
    protected FilterRegistrationBean registerThirdRequestHandlerProFilter()
    {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        AccessControlFilter accessControlFilter = new AccessControlFilter();
        registration.setAsyncSupported(true);
        registration.setFilter(accessControlFilter);

        registration.addUrlPatterns("/");
        return registration;
    }
}
