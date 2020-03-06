package com.alice.dubbo.provider.dubbo03provider.invest;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

class IInvestTest {

    @Test
    void invest() {
        IInvest personInvest = ExtensionLoader.getExtensionLoader(IInvest.class).getExtension("personInvest");
        personInvest.invest(1000D);

        IInvest defaultExtension = ExtensionLoader.getExtensionLoader(IInvest.class).getDefaultExtension();
        String invest = defaultExtension.invest(10000D);
        System.out.println(invest);
    }
}