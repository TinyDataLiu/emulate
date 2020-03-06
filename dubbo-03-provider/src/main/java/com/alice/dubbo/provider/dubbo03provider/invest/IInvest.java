package com.alice.dubbo.provider.dubbo03provider.invest;

import org.apache.dubbo.common.extension.SPI;

@SPI("personInvest")
public interface IInvest {
    String invest(Double amt);
}
