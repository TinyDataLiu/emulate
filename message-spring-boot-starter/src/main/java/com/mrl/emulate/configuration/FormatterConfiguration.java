package com.mrl.emulate.configuration;

import com.mrl.emulate.formatter.JsonFormat;
import com.mrl.emulate.formatter.StringFormat;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 统一管理所有的formatter
 *
 * @author liuchun
 * @date 2020/02/28  16:18
 */
@Configuration
public class FormatterConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    StringFormat stringFormat() {
        return new StringFormat();
    }


    @Bean
    @ConditionalOnClass(name = {"com.alibaba.fastjson.JSON"})
    JsonFormat jsonFormat() {
        return new JsonFormat();
    }
}
