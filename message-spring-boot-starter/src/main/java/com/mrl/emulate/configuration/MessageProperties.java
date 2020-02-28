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
    public static final String MESSAGE_PROPERTIES_PREFIX = "message";

    private Map<String, Object> info;
    private Set<String> ways;

    public Set<String> getWays() {
        return ways;
    }

    public void setWays(Set<String> ways) {
        this.ways = ways;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
