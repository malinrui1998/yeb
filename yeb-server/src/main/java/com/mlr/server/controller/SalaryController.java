package com.mlr.server.controller;


import com.mlr.server.pojo.RespBean;
import com.mlr.server.pojo.Salary;
import com.mlr.server.service.ISalaryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
@RequestMapping("/salary/sob")
public class SalaryController {

    @Resource
    private ISalaryService salaryService;

    @ApiOperation(value = "获取所有工资账套")
    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        List<Salary> list = salaryService.list();
        return list;
    }

    @ApiOperation(value = "添加工资账套")
    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        salary.setCreateDate(LocalDateTime.now());
        if (salaryService.save(salary)) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新工资账套")
    @PutMapping("/")
    public RespBean updateSalary(@RequestBody Salary salary) {
        if (salaryService.updateById(salary)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除工资账套")
    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.removeById(id)) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
