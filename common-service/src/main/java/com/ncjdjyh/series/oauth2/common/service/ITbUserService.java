package com.ncjdjyh.series.oauth2.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
public interface ITbUserService extends IService<TbUser> {
    TbUser getUserByPhone(String account);

    TbUser getUserByName(String name);
}
