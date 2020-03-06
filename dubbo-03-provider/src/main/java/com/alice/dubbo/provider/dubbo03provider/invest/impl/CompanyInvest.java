package com.alice.dubbo.provider.dubbo03provider.invest.impl;

import com.alice.dubbo.provider.dubbo03provider.invest.IInvest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyInvest implements IInvest {
    @Override
    public String invest(Double amt) {
        log.info("{}", amt);
        return "000";
    }
}
