package com.alice.dubbo.provider.dubbo03provider;

import com.mrl.emulate.api.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service(version = "1.0")
public class LoginServiceImplV1 implements LoginService {
    @Override
    public String login(String username, String password) {
        log.info("username={},password={}", username, password);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return username + "_" + password;
    }
}
