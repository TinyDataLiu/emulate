package com.alice.spring.boot.autoconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuchun
 * @date 2020/02/28  10:04
 */
@SpringBootApplication
@EnableService(exclude = {LoggerService.class})
public class EnableDemo {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableDemo.class, args);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            if (name.startsWith("com.alice.spring.boot.autoconfigdemo")) {
                System.err.println(name);
            }

        }
    }
}
