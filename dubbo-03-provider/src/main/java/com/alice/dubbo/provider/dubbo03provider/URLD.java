package com.alice.dubbo.provider.dubbo03provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Slf4j
public class URLD {
    public static void main(String[] args) throws UnsupportedEncodingException {
        CuratorFramework build = CuratorFrameworkFactory.builder().connectString("192.168.1.153:2181").namespace("dubbo").retryPolicy(new RetryOneTime(1000)).build();
        build.start();
        try {
            List<String> path = build.getChildren().forPath("/com.mrl.emulate.api.EmpService/providers");
            path.forEach(s -> {
                try {

                    log.info("{}", URLDecoder.decode(s, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });


            build.getChildren().forPath("/com.mrl.emulate.api.LoginService/consumers").forEach(s -> {
                try {
                    log.info("{}", URLDecoder.decode(s, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
