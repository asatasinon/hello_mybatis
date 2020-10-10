package com.sinon.hello;

import com.sinon.hello.service.AnnouncementService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan("com.sinon.hello.mapper")
//语句的意义：排除 数据源的自动初始化配置 ；但经测试，不排除也没问题
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@SpringBootApplication
@EnableCaching
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
