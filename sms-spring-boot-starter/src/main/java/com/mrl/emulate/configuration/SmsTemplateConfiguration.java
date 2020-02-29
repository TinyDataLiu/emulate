package com.mrl.emulate.configuration;

import com.mrl.emulate.SmsTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuchun
 * @date 2020/02/29  10:46
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsTemplateConfiguration {
    @Bean
    public SmsTemplate smsTemplate(SmsProperties smsProperties) {
        return new SmsTemplate(smsProperties);
    }
}