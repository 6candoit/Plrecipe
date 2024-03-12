package com.sixcandoit.plrecipe_post.query.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sixcandoit", annotationClass = Mapper.class)
public class MyBatisConfig {
}
