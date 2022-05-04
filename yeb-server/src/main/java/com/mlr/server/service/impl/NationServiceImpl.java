package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.mapper.NationMapper;
import com.mlr.server.pojo.Nation;
import com.mlr.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
