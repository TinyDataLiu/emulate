package com.alice.nacos.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }


    @RestController
    class EchoController {

        @RequestMapping("/echo/{str}")
        public String echo(@PathVariable("str") String str) {
            log.info("Hello Nacos Discovery {}", str);
            return "Hello Nacos Discovery " + str;
        }
    }
}
