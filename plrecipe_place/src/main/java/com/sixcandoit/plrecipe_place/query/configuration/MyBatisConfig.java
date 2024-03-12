package com.sixcandoit.plrecipe_place.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sixcandoit.plrecipe_place.query", annotationClass = Mapper.class)
public class MyBatisConfig {
}
