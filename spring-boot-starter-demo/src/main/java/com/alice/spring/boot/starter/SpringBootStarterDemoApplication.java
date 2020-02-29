package com.alice.spring.boot.starter;

import com.mrl.emulate.FormatterTemplate;
import com.mrl.emulate.SmsTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootStarterDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootStarterDemoApplication.class, args);

        SmsTemplate smsTemplate = context.getBean(SmsTemplate.class);


        for (int i = 0; i < 100; i++) {
            smsTemplate.send("153", "message-" + i);
        }
    }

}
