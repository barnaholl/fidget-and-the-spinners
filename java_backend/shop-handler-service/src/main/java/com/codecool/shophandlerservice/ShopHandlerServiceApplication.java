package com.codecool.shophandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopHandlerServiceApplication.class, args);
	}

}
