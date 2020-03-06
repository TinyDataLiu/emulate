package com.alice.dubbo.consumer.dubbo03consumer.mock;

import com.mrl.emulate.api.LoginService;

public class MockLoginService implements LoginService {
    @Override
    public String login(String username, String password) {
        return "Sorry,  服务端发生异常，被降级啦！";
    }
}
