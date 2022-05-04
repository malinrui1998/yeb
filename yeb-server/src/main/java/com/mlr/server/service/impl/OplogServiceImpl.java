package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.mapper.OplogMapper;
import com.mlr.server.pojo.Oplog;
import com.mlr.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
