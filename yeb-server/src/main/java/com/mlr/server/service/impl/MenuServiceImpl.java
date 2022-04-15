package com.mlr.server.service.impl;

import com.mlr.server.pojo.Admin;
import com.mlr.server.pojo.Menu;
import com.mlr.server.mapper.MenuMapper;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.utils.AdminUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RedisTemplate redisTemplate;
    /**
     * 通过用户id查询菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getCurrentAdmin().getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //从redis获取菜单数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
        //如果为空，去数据库获取
        if (CollectionUtils.isEmpty(menus)){
            menus = menuMapper.getMenusByAdminId(adminId);
            //将数据设置到Redis中
            valueOperations.set("menu_"+adminId,menus);
        }
        return menus;
    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }


}
