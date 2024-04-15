package com.example.dreamappgoals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DreamAppGoalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamAppGoalsApplication.class, args);
	}

}
