package com.mlr.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlr.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id查询角色列表
     *
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
