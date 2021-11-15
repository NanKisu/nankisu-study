package com.example.openbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenbankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenbankingApplication.class, args);
	}

}
