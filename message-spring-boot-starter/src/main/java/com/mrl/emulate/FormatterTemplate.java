package com.mrl.emulate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mrl.emulate.configuration.MessageProperties;
import com.mrl.emulate.enums.MessageChannelEnum;
import com.mrl.emulate.formatter.FormatterProcessor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 提供统一的对外访问入口
 *
 * @author liuchun
 * @date 2020/02/28  16:33
 */
public class FormatterTemplate {


    private final Map<MessageChannelEnum, Integer> roteMap = new HashMap<>();


    private FormatterProcessor formatterProcessor;
    private MessageProperties messageProperties;

    public FormatterTemplate(FormatterProcessor formatterProcessor) {
        this.formatterProcessor = formatterProcessor;
    }

    public FormatterTemplate(FormatterProcessor formatterProcessor, MessageProperties messageProperties) {
        this.formatterProcessor = formatterProcessor;
        this.messageProperties = messageProperties;
        //将短信通道用量信息初始化
        for (MessageChannelEnum messageChannelEnum : MessageChannelEnum.values()) {
            roteMap.put(messageChannelEnum, 0);
        }
    }

    public <T> String format(T obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("begin:Execute format").append("<br/>");
        stringBuilder.append("properties format result:").append(formatterProcessor.format(messageProperties)).append("<br/>");
        stringBuilder.append("Obj format result:").append(formatterProcessor.format(obj)).append("<br/>");
        return stringBuilder.toString();
    }


    public JSONObject sendMessage(MessageChannelEnum messageChannelEnum, String phone, String contentKey) {
        // 选出当前用量最少的短信服务
        Map.Entry<MessageChannelEnum, Integer> channelEnumIntegerEntry = roteMap.entrySet().stream().min((o1, o2) -> o1.getValue() - o2.getValue()).get();
        MessageChannelEnum key = channelEnumIntegerEntry.getKey();
        System.out.println(key.name());
        roteMap.put(key, roteMap.get(key) + 1);
        return JSON.parseObject("");
    }

}
