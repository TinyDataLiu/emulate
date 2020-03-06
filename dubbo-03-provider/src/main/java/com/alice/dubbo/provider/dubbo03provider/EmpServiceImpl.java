package com.alice.dubbo.provider.dubbo03provider;

import com.mrl.emulate.api.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public void add(String e) {
        log.info("add={}", e);
    }
}
