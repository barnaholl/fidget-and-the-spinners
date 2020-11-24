package com.codecool.userhandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserHandlerServiceApplication.class, args);
	}

}
