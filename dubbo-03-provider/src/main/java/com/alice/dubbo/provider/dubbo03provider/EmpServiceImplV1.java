package com.alice.dubbo.provider.dubbo03provider;

import com.mrl.emulate.api.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service(cluster = "failover")
public class EmpServiceImplV1 implements EmpService {
    @Override
    public void add(String e) {
        log.info("add={}", e);
    }
}
