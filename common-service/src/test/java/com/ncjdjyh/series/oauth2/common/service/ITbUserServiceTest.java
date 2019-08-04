package com.ncjdjyh.series.oauth2.common.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/3
 * @Description: ~
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ITbUserServiceTest {
    @Autowired
    private ITbUserService userService;

    @Test
    public void getUserByPhone() {
        userService.getUserByPhone("15888888888");
    }
}