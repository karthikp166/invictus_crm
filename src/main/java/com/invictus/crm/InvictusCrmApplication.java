package com.invictus.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class InvictusCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvictusCrmApplication.class, args);
	}
	
}
