package com.alice.spring.boot.spi;

import com.mrl.emulate.AliceConfiguration;
import com.mrl.emulate.AliceCore;
import com.mrl.emulate.AlixiyaCore;
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
//        如果不用SPI 直接将配置bean 导入可以将 AliceCore 交给spring 管理
//        ConfigurableApplicationContext context = SpringApplication.run(new Class[]{SPITest.class, AliceConfiguration.class}, args);
//        AliceCore aliceCore = context.getBean(AliceCore.class);
//        System.out.println(aliceCore.foo());
//
//        使用SPI 机制来加载Bean
        ConfigurableApplicationContext context = SpringApplication.run(new Class[]{SPITest.class}, args);

        AlixiyaCore alixiyaCore = context.getBean(AlixiyaCore.class);
        alixiyaCore.foo();
    }
}
