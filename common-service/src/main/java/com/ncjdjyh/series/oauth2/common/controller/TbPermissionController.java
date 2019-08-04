package com.ncjdjyh.series.oauth2.common.controller;


import com.ncjdjyh.series.oauth2.common.entity.TbPermission;
import com.ncjdjyh.series.oauth2.common.service.ITbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
@RestController
@RequestMapping("/permission")
public class TbPermissionController {
    @Autowired
    ITbPermissionService service;

    @GetMapping("/getAllUserPermission/{id}")
    public List<TbPermission> getAllUserPermission(@PathVariable Long id) {
        return service.selectByUserId(id);
    }
}

