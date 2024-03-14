package com.sixcandoit.plrecipe_group.command;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PlrecipeGroupCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlrecipeGroupCommandApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
