package com.fdse.is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class InformationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationServiceApplication.class, args);
	}
}
