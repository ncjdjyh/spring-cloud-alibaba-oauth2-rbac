package com.ncjdjyh.series.oauth2.common.service.impl;

import com.ncjdjyh.series.oauth2.common.entity.TbUser;
import com.ncjdjyh.series.oauth2.common.mapper.TbUserMapper;
import com.ncjdjyh.series.oauth2.common.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
