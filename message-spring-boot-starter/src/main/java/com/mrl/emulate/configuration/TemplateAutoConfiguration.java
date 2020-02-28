package com.mrl.emulate.configuration;

import com.mrl.emulate.FormatterTemplate;
import com.mrl.emulate.formatter.FormatterProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liuchun
 * @date 2020/02/28  16:30
 */
@Import(FormatterConfiguration.class)
@EnableConfigurationProperties(MessageProperties.class)
@Configuration
public class TemplateAutoConfiguration {
    @Bean
    FormatterTemplate formatterTemplate(FormatterProcessor formatterProcessor, MessageProperties messageProperties) {
        return new FormatterTemplate(formatterProcessor, messageProperties);
    }
}
