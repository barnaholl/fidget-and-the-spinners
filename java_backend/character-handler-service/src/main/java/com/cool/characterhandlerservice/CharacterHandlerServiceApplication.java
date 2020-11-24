package com.cool.characterhandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CharacterHandlerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharacterHandlerServiceApplication.class, args);
	}

}
