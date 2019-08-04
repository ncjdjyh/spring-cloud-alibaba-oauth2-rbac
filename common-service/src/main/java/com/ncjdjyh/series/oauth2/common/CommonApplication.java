package com.ncjdjyh.series.oauth2.common;

import com.ncjdjyh.series.oauth2.common.annotation.EnableInnerResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;


/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/2
 * @Description: ~
 */
@SpringCloudApplication
@MapperScan("com.ncjdjyh.series.oauth2.common.mapper")
@EnableInnerResourceServer
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }
}
