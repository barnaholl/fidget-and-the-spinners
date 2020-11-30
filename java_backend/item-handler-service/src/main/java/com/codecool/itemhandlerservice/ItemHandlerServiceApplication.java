package com.codecool.itemhandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemHandlerServiceApplication.class, args);
	}

}
