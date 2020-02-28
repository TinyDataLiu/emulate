package com.alice.spring.boot.starter;

import com.mrl.emulate.FormatterTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootStarterDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootStarterDemoApplication.class, args);
        FormatterTemplate template = context.getBean(FormatterTemplate.class);
        User user = new User();
        user.setAge(18);
        user.setName("alice");
        String format = template.format(user);
        System.err.println(format);
    }

}
