package com.alice.dubbo.service;

import com.mrl.emulate.api.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public String login(String username, String password) {
        System.out.println(username + "_" + password);
        return username + password;
    }
}
