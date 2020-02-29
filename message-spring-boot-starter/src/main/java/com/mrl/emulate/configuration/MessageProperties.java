package com.mrl.emulate.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;
import java.util.Set;

/**
 * @author liuchun
 * @date 2020/02/28  16:58
 */
@ConfigurationProperties(prefix = MessageProperties.MESSAGE_PROPERTIES_PREFIX)
public class MessageProperties {

    /**
     * 定义前缀
     */
    public static final String MESSAGE_PROPERTIES_PREFIX = "sms";


    private String channel = "message_";
}
