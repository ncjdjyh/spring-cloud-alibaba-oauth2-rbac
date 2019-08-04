package com.ncjdjyh.series.oauth2.common.service.impl;

import com.ncjdjyh.series.oauth2.common.entity.TbPermission;
import com.ncjdjyh.series.oauth2.common.service.ITbPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/2
 * @Description: ~
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TbPermissionServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(TbPermissionServiceImplTest.class);
    @Autowired
    private ITbPermissionService service;

    @Test
    public void selectByUserId() {
        List<TbPermission> list = service.selectByUserId(37);
//        TbPermission permission = service.getById(37);
        System.out.println(list);
    }

    @Test
    public void test() {
        logger.warn("warning");
    }
}