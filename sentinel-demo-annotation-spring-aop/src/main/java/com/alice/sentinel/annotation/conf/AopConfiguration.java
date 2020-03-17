package com.alice.sentinel.annotation.conf;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        SentinelResourceAspect aspect = new SentinelResourceAspect();
        return aspect;
    }
}
