package com.alice.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("config")
public class ConfigController {

    @Value("${username}")
    private String username;


    @GetMapping("get")
    public String getUsername() {
        return username;
    }
}
