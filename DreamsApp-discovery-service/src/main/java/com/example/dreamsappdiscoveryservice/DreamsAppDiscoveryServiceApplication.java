package com.example.dreamsappdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DreamsAppDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DreamsAppDiscoveryServiceApplication.class, args);
    }

}
