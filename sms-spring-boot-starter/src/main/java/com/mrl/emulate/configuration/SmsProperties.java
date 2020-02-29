package com.mrl.emulate.configuration;

import com.mrl.emulate.enums.SmsChannelEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liuchun
 * @date 2020/02/29  10:48
 */
@ConfigurationProperties(prefix = SmsProperties.SMS_PROPERTIES_PREFIX)
public class SmsProperties {

    public static final String SMS_PROPERTIES_PREFIX = "sms.service";

    /**
     * channel of sms service
     */
    private SmsChannelEnum channel;

    /**
     * the request buz no
     */
    private String requestNo;


    /**
     * the client of request
     */
    private String client;

    public SmsChannelEnum getChannel() {
        return channel;
    }

    public void setChannel(SmsChannelEnum channel) {
        this.channel = channel;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
