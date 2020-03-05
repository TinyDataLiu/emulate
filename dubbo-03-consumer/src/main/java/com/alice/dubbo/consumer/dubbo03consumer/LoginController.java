package com.alice.dubbo.consumer.dubbo03consumer;

import com.mrl.emulate.api.LoginService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Reference
    private LoginService loginService;

    @GetMapping("login")
    public String login(String u, String p) {
        return loginService.login(u, p);
    }

}
