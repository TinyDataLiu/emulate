package com.alice.dubbo.provider.dubbo03provider.pay.impl;

import com.alice.dubbo.provider.dubbo03provider.pay.IPay;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WchatPay implements IPay {
    @Override
    public String diPay(Integer amt) {
        log.info("{}", amt);

        return "success";
    }
}
