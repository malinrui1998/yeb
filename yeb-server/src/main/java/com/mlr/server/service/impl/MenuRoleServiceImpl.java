package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mlr.server.mapper.MenuMapper;
import com.mlr.server.pojo.MenuRole;
import com.mlr.server.mapper.MenuRoleMapper;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Resource
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     *
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>()
                .eq("rid", rid));
        if (mids == null || mids.length == 0) {
            return RespBean.success("更新成功");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if (mids.length == result) {
            return RespBean.success("更新成功");
        }
        return null;
    }

}
