package com.ncjdjyh.series.oauth2.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbPermission;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
public interface ITbPermissionService extends IService<TbPermission> {
    List<TbPermission> selectByUserId(long id);
}
