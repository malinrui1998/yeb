package com.mlr.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlr.server.pojo.Admin;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface AdminMapper extends BaseMapper<Admin> {


    /**
     * 获取所有操作员
     *
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(Integer id, String keywords);
}
