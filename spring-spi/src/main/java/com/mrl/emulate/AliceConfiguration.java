package com.mrl.emulate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuchun
 * @date 2020/02/28  13:17
 */
@Configuration
public class AliceConfiguration {

    @Bean
    public AliceCore aliceCore() {
        return new AliceCore();
    }
}
