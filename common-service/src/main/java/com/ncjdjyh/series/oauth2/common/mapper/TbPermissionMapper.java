package com.ncjdjyh.series.oauth2.common.mapper;

import com.ncjdjyh.series.oauth2.common.entity.TbPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
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
