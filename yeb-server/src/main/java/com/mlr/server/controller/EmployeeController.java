package com.mlr.server.controller;


import com.mlr.server.pojo.*;
import com.mlr.server.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
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
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Resource
    private IEmployeeService employeeService;
    @Resource
    private IPositionService positionService;
    @Resource
    private INationService nationService;
    @Resource
    private IPoliticsStatusService politicsStatusService;
    @Resource
    private IJoblevelService joblevelService;
    @Resource
    private IDepartmentService departmentService;

    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    Employee employee,
                                    LocalDate[] beginDateScope) {
        return employeeService.getEmployeeByPage(currentPage, size, employee, beginDateScope);
    }

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/politicsStatus")
    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusService.list();
    }

    @ApiOperation(value = "获取所有民族")
    @GetMapping("/nation")
    public List<Nation> getAllNations() {
        return nationService.list();
    }

    @ApiOperation(value = "获取所有职位")
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/joblevel")
    public List<Joblevel> getAllJoblelevel() {
        return joblevelService.list();
    }

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/deps")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "获取工号")
    @GetMapping("/maxWorkID")
    public RespBean maxWordID() {
        return employeeService.maxWordID();
    }

    @ApiOperation(value = "添加员工")
    @PostMapping("/")
    public RespBean addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @ApiOperation(value = "更新员工信息")
    @PutMapping("/")
    public RespBean updateEmployee(@RequestBody Employee employee) {
        if (employeeService.updateById(employee)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除员工信息")
    @DeleteMapping("/{id}")
    public RespBean deleteEmployee(@PathVariable String id) {
        if (employeeService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
