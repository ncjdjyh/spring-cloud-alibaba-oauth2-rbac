package com.ncjdjyh.series.oauth2.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/8
 * @Description: ~
 */
@RestController
public class TestController {
    @GetMapping("/users/view/{id}")
    public String getUser(@PathVariable String id) {
        return id;
    }

    @GetMapping("/noAuth")
    public String noAuth() {
        return "noAuth";
    }
}
