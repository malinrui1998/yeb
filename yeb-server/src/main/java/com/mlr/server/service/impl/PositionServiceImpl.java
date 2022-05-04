package com.mlr.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlr.server.mapper.PositionMapper;
import com.mlr.server.pojo.Position;
import com.mlr.server.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

}
