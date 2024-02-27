package com.sixcandoit.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sixcandoit.plrecipe.feature", annotationClass = Mapper.class)
public class PlrecipeConfiguration {
}
