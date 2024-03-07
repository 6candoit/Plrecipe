package com.sixcandoit.plrecipe_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class PlrecipeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlrecipeGatewayApplication.class, args);
	}

}
