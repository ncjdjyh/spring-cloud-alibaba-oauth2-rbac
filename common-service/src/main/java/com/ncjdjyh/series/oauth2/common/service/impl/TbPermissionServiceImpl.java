package com.ncjdjyh.series.oauth2.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ncjdjyh.series.oauth2.common.mapper.TbPermissionMapper;
import com.ncjdjyh.series.oauth2.common.service.ITbPermissionService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionMapper, TbPermission> implements ITbPermissionService {
    @Autowired
    private TbPermissionMapper mapper;

    @Override
    public List<TbPermission> selectByUserId(long id) {
        return mapper.selectByUserId(id);
    }
}
