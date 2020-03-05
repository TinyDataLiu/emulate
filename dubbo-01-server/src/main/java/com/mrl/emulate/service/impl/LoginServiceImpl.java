package com.mrl.emulate.service.impl;


import com.mrl.emulate.api.LoginService;

/**
 * 接口实现类，用于对外提供服务
 */
public class LoginServiceImpl implements LoginService {

    public String login(String username, String password) {
        System.out.println(username + ">>>>>>>>>" + password);
        if (username.equals("alice")) {
            return "success";
        }
        return "fail";
    }
}
