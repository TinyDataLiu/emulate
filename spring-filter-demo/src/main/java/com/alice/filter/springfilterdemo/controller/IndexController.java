package com.alice.filter.springfilterdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IndexController {

    @GetMapping("login")
    public String login() {
        return UUID.randomUUID().toString();
    }
}
