package com.alice.spring.boot.starter;

import com.mrl.emulate.SmsTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStarterDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SmsTemplate smsTemplate;


    @Test
    public void testSendMessage() {
        for (int i = 0; i < 100; i++) {
            smsTemplate.send("15313112907", "message" + i);
        }
    }


}
