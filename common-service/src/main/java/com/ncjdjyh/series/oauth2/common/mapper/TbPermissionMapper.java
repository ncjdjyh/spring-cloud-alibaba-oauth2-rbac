package com.ncjdjyh.series.oauth2.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ncjdjyh.series.oauth2.dependencies.entity.TbPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author ncjdjyh
 * @since 2019-08-01
 */
public interface TbPermissionMapper extends BaseMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") long id);
}
