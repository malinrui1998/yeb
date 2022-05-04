package com.mlr.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlr.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 批量角色更新
     * @param rid
     * @param mids
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
