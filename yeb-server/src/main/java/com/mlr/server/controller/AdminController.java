package com.mlr.server.controller;


import com.mlr.server.pojo.Admin;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.pojo.Role;
import com.mlr.server.service.IAdminService;
import com.mlr.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Resource
    private IAdminService adminService;

    @Resource
    private IRoleService roleService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords) {
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin) {
        if (adminService.updateById(admin)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除操作员")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable String id) {
        if (adminService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "获取所有操作员角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {
        return adminService.updateAdminRole(adminId, rids);
//        }
    }


}
