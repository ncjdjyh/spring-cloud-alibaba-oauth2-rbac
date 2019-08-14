package com.ncjdjyh.series.oauth2.common.controller;


import com.ncjdjyh.series.oauth2.common.service.ITbUserService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
@RestController
@RequestMapping("/user")
public class TbUserController {
    @Autowired
    private ITbUserService service;

    @GetMapping("/getUserByAccount/{account}")
    public TbUser getUserByAccount(@PathVariable("account") String phone) {
        return service.getUserByPhone(phone);
    }

    @GetMapping("/getUserByUsername/{name}")
    public TbUser getUserByUsername(@PathVariable("name") String name) {
        return service.getUserByName(name);
    }
}

