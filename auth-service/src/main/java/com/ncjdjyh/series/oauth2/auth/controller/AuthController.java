package com.ncjdjyh.series.oauth2.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/12
 * @Description: ~
 */
@Controller
public class AuthController {
    @GetMapping("/oauth/github/callback")
    public String authorizeForGitHub(@RequestParam("state") String state, HttpSession session) {
        // 重定向到之前需要授权的页面
        return "redirect:" + state;
    }

    @GetMapping("/test")
    public String test() {
        return "hello";
    }
}
