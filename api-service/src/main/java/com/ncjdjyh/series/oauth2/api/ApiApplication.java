package com.ncjdjyh.series.oauth2.api;

import com.ncjdjyh.series.oauth2.dependencies.annotation.EnableInnerResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/3
 * @Description: ~
 */
@EnableInnerResourceServer
@SpringCloudApplication
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }
}
