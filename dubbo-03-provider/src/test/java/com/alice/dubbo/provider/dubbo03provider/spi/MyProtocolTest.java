package com.alice.dubbo.provider.dubbo03provider.spi;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;
import org.junit.jupiter.api.Test;

@Slf4j
class MyProtocolTest {

    @Test
    void export() {
        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("myProtocol2");
        log.info("protocol.getDefaultPort()={}", protocol.getDefaultPort());
    }
}