package com.mrl.emulate.stub;

import com.mrl.emulate.api.LoginService;

public class LoginServerStub implements LoginService {


    private final LoginService loginService;

    public LoginServerStub(LoginService loginService) {
        this.loginService = loginService;
    }


    @Override
    public String login(String username, String password) {
        String result = null;
        System.out.println("此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等");
        try {
//    这里会发起远程服务
            result = loginService.login(username, password);
        } catch (Exception e) {
            result = "服务端错误";
        }
        return result;
    }
}
