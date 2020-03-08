package com.alice.dubbo.provider.dubbo03provider;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //如果key 值为空
        String val = "";
        val = map.putIfAbsent("key", "wan");
        log.info("{}", val);

        val = map.computeIfAbsent("key", s -> {
            return "张三";
        });

        log.info("{}", val);
        val = map.computeIfAbsent("key", s -> {
            return "李四";
        });
        log.info("{}", val);




    }
}
