package com.alice.spring.boot.spi;

import com.mrl.emulate.AliceCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuchun
 * @date 2020/02/28  13:21
 */
@SpringBootApplication
public class SPITest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SPITest.class, args);
        AliceCore aliceCore = context.getBean(AliceCore.class);
        System.out.println(aliceCore.foo());
    }
}
