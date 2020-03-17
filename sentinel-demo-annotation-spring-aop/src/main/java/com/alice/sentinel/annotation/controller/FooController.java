package com.alice.sentinel.annotation.controller;

import com.alice.sentinel.annotation.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {


    @Autowired
    private FooService fooService;

    @GetMapping("foo")
    public String foo(String name) {
        return fooService.foo(name);
    }

    @GetMapping("call")
    public String call(String name) {
        return fooService.call(name);
    }

}
