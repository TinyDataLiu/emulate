package com.alice.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuchun
 * @date 2020/02/29  13:22
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("order")
    String order() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        log.info("创建订单");
        restTemplate.put("http://localhost:8081/repo/{1}", null, 1000);
        return "success";
    }
}
