package com.alice.dubbo.service;

import com.mrl.emulate.api.IUser;
import com.mrl.emulate.dto.User;

public class IUserImpl implements IUser {
    @Override
    public User add(User user) {
        System.out.println(user);
        user.setUsername("alice");
        user.setPassword("abc123");
        return user;
    }
}
