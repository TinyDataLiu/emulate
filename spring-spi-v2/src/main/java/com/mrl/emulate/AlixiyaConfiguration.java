package com.mrl.emulate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuchun
 * @date 2020/02/28  13:28
 */
@Configuration
public class AlixiyaConfiguration {


    @Bean
    AlixiyaCore alixiyaCore() {
        return new AlixiyaCore();
    }

}
