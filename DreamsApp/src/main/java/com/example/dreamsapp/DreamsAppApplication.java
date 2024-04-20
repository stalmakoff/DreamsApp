package com.example.dreamsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableDiscoveryClient //also can without
@EnableFeignClients
@SpringBootApplication
@EnableCaching

public class DreamsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamsAppApplication.class, args);
    }

}
