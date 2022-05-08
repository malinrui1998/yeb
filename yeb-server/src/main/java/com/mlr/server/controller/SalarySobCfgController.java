package com.mlr.server.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mlr.server.pojo.Employee;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.pojo.RespPageBean;
import com.mlr.server.pojo.Salary;
import com.mlr.server.service.IEmployeeService;
import com.mlr.server.service.ISalaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: mlr
 * @date: 2022/5/8 9:39
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/salary/cobcfg")
public class SalarySobCfgController {

    @Resource
    private ISalaryService salaryService;
    @Resource
    private IEmployeeService employeeService;

    @ApiOperation(value = "获取所有工资账套")
    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.list();
    }

    @ApiOperation(value = "获取所有员工账套")
    @GetMapping("/")
    public RespPageBean getEmployeeWithSalary(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeWithSalary(currentPage, size);
    }

    @ApiOperation(value = "更新员工账套")
    @PutMapping("/")
    public RespBean updateEmployeeSalary(Integer eid, Integer sid) {
        if (employeeService.update(new UpdateWrapper<Employee>().set("salaryId", sid).eq("id", eid))) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

}
