package com.alice.dubbo.provider.dubbo03provider.pay;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface IPay {

    String diPay(Integer amt);


    @Adaptive
    String doPay(URL url, Integer amt);
}
