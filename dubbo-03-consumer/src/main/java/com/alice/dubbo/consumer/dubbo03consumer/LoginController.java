package com.alice.dubbo.consumer.dubbo03consumer;

import com.mrl.emulate.api.LoginService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    /**
     * 修改配置，将mock 配置好
     * 以及设置timeout 时间= 1来模拟降级
     */
    @Reference(
            loadbalance = "roundrobin",
//            mock = "com.mrl.emulate.mock.MockLoginService",
            check = false,
            version = "1.0",
//            stub = "com.mrl.emulate.stub.LoginServerStub"
            cluster = "failfast"
    )
    private LoginService loginService;


    @GetMapping("login")
    public String login(String u, String p) {

        StringBuffer buffer = new StringBuffer();

        buffer.delete(0, buffer.capacity());
        return loginService.login(u, p);
    }


}
