package com.ncjdjyh.series.oauth2.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ncjdjyh.series.oauth2.common.mapper.TbRoleMapper;
import com.ncjdjyh.series.oauth2.common.service.ITbRoleService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbRole;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
@Service
public class TbRoleServiceImpl extends ServiceImpl<TbRoleMapper, TbRole> implements ITbRoleService {

}
