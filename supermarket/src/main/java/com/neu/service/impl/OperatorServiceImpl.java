package com.neu.service.impl;

import com.neu.dao.OperatorMapper;
import com.neu.service.OperatorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员表(Operator)表服务实现类
 *
 * @author makejava
 * @since 2020-09-19 21:50:27
 */
@Service("operatorService")
public class OperatorServiceImpl implements OperatorService {

    @Resource
    private OperatorMapper operatorDao;


}