package com.mlr.server.controller;


import com.mlr.server.pojo.Department;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.service.IDepartmentService;
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
@RequestMapping("/system/basic/department")
public class DepartmentController {

    @Resource
    private IDepartmentService departmentService;

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/")
    public RespBean addDepartment(@RequestBody Department department) {
        return departmentService.addDep(department);
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable Integer id){
        return departmentService.deleteDepartment(id);
    }
}
