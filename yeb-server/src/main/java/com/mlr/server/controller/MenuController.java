package com.mlr.server.controller;


import com.mlr.server.pojo.Menu;
import com.mlr.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/system/config")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询用户列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId() {
        return menuService.getMenusByAdminId();
    }
}
