package com.sixcandoit.plrecipe.common;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sixcandoit.plrecipe", annotationClass = Mapper.class)
public class MyBatisConfig {
}