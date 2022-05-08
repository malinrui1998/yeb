package com.mlr.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mlr.server.pojo.Employee;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     *
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     *
     * @return
     */
    RespBean maxWordID();

    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    RespBean addEmployee(Employee employee);

    /**
     * 查询员工
     *
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     *
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
