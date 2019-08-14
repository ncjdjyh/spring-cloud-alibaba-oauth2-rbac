package com.ncjdjyh.series.oauth2.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ncjdjyh.series.oauth2.common.mapper.TbUserMapper;
import com.ncjdjyh.series.oauth2.common.service.ITbUserService;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {
    @Autowired
    private TbUserMapper mapper;

    @Override
    public TbUser getUserByPhone(String account) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TbUser::getPhone, account);
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public TbUser getUserByName(String name) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TbUser::getUsername, name);
        return mapper.selectOne(queryWrapper);
    }
}
