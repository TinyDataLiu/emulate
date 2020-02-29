package com.alice.spring.boot.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuchun
 * @date 2020/02/29  12:31
 */
@RestController
public class HelloController {

    @GetMapping("foo")
    public String foo() {
        return "foo";
    }

}
