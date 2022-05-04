package com.mlr.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlr.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mlr
 * @since 2022-04-11
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @return
     */
    void addDep(Department department);

    /**
     * 删除部门
     * @param department
     */
    void deleteDepartment(Department department);
}
