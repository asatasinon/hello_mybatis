package com.sinon.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


//mybatis的mapper文件扫描
@MapperScan("com.sinon.hello.mapper")
//springboot程序入口
@SpringBootApplication
//语句的意义：排除 数据源的自动初始化配置 ；但经测试，不排除也没问题
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
// 启用定时任务
@EnableScheduling
// 启用缓存
@EnableCaching
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
