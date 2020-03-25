package com.alice.dubbo.provider.dubbo03provider.invest;

import com.alice.dubbo.provider.dubbo03provider.Dubbo03ProviderApplication;
import com.alice.dubbo.provider.dubbo03provider.invest.impl.PersonInvest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class IInvestTest {

    @Test
    void invest() {
//        IInvest personInvest = ExtensionLoader.getExtensionLoader(IInvest.class).getExtension("personInvest");
//        personInvest.invest(1000D);
//
//        IInvest defaultExtension = ExtensionLoader.getExtensionLoader(IInvest.class).getDefaultExtension();
//        String invest = defaultExtension.invest(10000D);
//        System.out.println(invest);
//

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Dubbo03ProviderApplication.class);

        PersonInvest bean = context.getBean(PersonInvest.class);




        bean.invest(1000D);

    }
}