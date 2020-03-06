package com.alice.dubbo.provider.dubbo03provider.pay.impl;

import com.alice.dubbo.provider.dubbo03provider.pay.IPay;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

@Slf4j
class AliPayTest {

    @Test
    void diPay() {
        IPay pay1 = ExtensionLoader.getExtensionLoader(IPay.class).getExtension("alipay");
        IPay pay2 = ExtensionLoader.getExtensionLoader(IPay.class).getExtension("wchatPay");

        pay1.diPay(1000);
        pay2.diPay(1000);
    }
}