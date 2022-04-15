package com.mlr.server.service.impl;

import com.mlr.server.pojo.Department;
import com.mlr.server.mapper.DepartmentMapper;
import com.mlr.server.pojo.RespBean;
import com.mlr.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 添加部门
     *
     * @return
     */
    @Override
    public RespBean addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        if (1 == department.getResult()) {
            return RespBean.success("添加成功", department);
        }
        return RespBean.error("添加失败");
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDepartment(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDepartment(department);
        if (department.getResult() == -2) {
            return RespBean.error("该部门下还有子部门，删除失败！");
        }
        if (department.getResult() == -1) {
            return RespBean.error("该部门下还有员工，删除失败！");
        }
        if (department.getResult() == 1) {
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}
