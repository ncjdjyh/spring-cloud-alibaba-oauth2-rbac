package com.ncjdjyh.series.oauth2.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/2
 * @Description: ~
 */
@EnableFeignClients
@SpringCloudApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
