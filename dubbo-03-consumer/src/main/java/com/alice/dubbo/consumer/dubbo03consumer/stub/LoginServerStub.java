package com.alice.dubbo.consumer.dubbo03consumer.stub;

import com.mrl.emulate.api.LoginService;

public class LoginServerStub implements LoginService {


    private final LoginService loginService;

    public LoginServerStub(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public String login(String username, String password) {
        String result = null;
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        try {
            loginService.login(username, password);
        } catch (Exception e) {
            // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        }
        return null;
    }
}
