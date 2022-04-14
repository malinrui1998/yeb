package com.mlr.server.service;

import com.mlr.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mlr.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
