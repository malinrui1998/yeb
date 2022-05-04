package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.mapper.SalaryMapper;
import com.mlr.server.pojo.Salary;
import com.mlr.server.service.ISalaryService;
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
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

}
