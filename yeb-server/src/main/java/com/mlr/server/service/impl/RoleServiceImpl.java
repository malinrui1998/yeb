package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.mapper.RoleMapper;
import com.mlr.server.pojo.Role;
import com.mlr.server.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
