package com.mrl.emulate;

import com.mrl.emulate.configuration.SmsProperties;
import com.mrl.emulate.enums.SmsChannelEnum;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuchun
 * @date 2020/02/29  10:46
 */
public class SmsTemplate {


    private SmsProperties smsProperties;

    /**
     * 用于记录短信通道使用次数
     */
    private static final Map<SmsChannelEnum, AtomicInteger> roteMap = new ConcurrentHashMap<>();


    public SmsTemplate(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
        // 初始化路由
        if (roteMap.isEmpty()) {
            for (SmsChannelEnum smsChannelEnum : SmsChannelEnum.values()) {
                roteMap.put(smsChannelEnum, new AtomicInteger(0));
            }
        }
    }

    /**
     * 发送短信
     *
     * @param phone
     * @param context
     * @return
     */
    public int send(String phone, String context) {
        // 如果调用方指定了短信服务的通道，则选择指定通道发送，
        // 如果没有选择指定通道，就选择用量最少的通道进行发送
        SmsChannelEnum channelEnum =
                smsProperties.getChannel() == null ?
                        roteMap.entrySet().stream().min((o1, o2) -> o1.getValue().get() - o2.getValue().get()).get().getKey()
                        : smsProperties.getChannel();
        System.out.println(String.format("短信通道：%s ,手机号：%s ,短信内容：%s", channelEnum.name(), phone, context));

        //返回发送结果
        return 0;
    }
}
