package com.sixcandoit.plrecipe_post.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


/* 설명. http://localhost:8080/swagger-ui/index.html */
@OpenAPIDefinition(
        info = @Info(title = "Plrecipe-Post API 명세서",
                description = "plrecipe 게시글 서비스 api 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {



}