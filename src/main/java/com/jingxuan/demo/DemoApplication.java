package com.jingxuan.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.jingxuan.demo.dao", "com.jingxuan.demo.mapper"})
@ServletComponentScan(basePackages = {"com.jingxuan.demo.filter"})
@Slf4j
@EnableScheduling
@ComponentScan(basePackages = {"com.jingxuan.demo.kafka"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
