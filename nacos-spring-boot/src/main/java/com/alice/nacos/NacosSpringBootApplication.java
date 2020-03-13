package com.alice.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSpringBootApplication.class, args);
    }

}
