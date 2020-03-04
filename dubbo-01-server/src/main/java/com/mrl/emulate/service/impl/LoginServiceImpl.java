package com.mrl.emulate.service.impl;


import com.mrl.emulate.api.LoginService;

public class LoginServiceImpl implements LoginService {

    public String login(String username, String password) {
        System.out.println(username + ">>>>>>>>>" + password);
        if (username.equals("alice")) {
            return "success";
        }
        return "fail";
    }
}
