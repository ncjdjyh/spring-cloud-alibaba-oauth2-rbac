package com.ncjdjyh.series.oauth2.auth.service;

import com.ncjdjyh.series.oauth2.dependencies.constant.DefaultSecurityConstants;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbPermission;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/2
 * @Description: ~
 */
@FeignClient(value = "common-service")
public interface AuthService {
    /**
     * @param account 电话号码
     * @param from 内部调用标识
     * @return com.ncjdjyh.series.oauth2.common.entity.TbUser
     * @description: ~
     */
    @GetMapping(value = "/user/getUserByAccount/{account}")
    TbUser getUserByPhone(@PathVariable("account") String account, @RequestHeader(DefaultSecurityConstants.FROM) String from);

    /**
     * @param username
     * @param from
     * @return com.ncjdjyh.series.oauth2.dependencies.entity.TbUser
     * @description: ~
     */
    @GetMapping(value = "/user/getUserByAccount/{name}")
    TbUser getUserByName(@PathVariable("name") String username, @RequestHeader(DefaultSecurityConstants.FROM) String from);

    /**
     * @param id   用户 id
     * @param from 内部调用标识
     * @return java.util.List<com.ncjdjyh.series.oauth2.common.entity.TbPermission>
     * @description: ~
     */
    @GetMapping(value = "/permission/getAllUserPermission/{id}")
    List<TbPermission> getAllUserAuth(@PathVariable("id") long id, @RequestHeader(DefaultSecurityConstants.FROM) String from);
}
