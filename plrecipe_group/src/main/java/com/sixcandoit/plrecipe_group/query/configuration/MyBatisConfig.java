package com.sixcandoit.plrecipe_group.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sixcandoit.plrecipe_group", annotationClass = Mapper.class)
public class MyBatisConfig {
}
