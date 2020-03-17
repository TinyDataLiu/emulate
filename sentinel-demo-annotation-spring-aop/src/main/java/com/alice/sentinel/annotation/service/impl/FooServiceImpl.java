package com.alice.sentinel.annotation.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alice.sentinel.annotation.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FooServiceImpl implements FooService {
    @Override
    @SentinelResource(defaultFallback = "defaultFallback")
    public String foo(String name) {
        log.info("name={}", name);
        return "name: " + name;
    }

    @Override
    @SentinelResource(defaultFallback = "defaultFallback", fallback = "callfallback")
    public String call(String name) {
        return "call " + name;
    }


    public String defaultFallback() {
        log.info("==================");
        return "defaultFallback";
    }

    public String callfallback() {
        return "callfallback";
    }
}
