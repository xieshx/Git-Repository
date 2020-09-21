package com.neu.service.impl;

import com.neu.dao.SaleRecordMapper;
import com.neu.service.SaleRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 销售记录表(SaleRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-09-19 21:50:28
 */
@Service("saleRecordService")
public class SaleRecordServiceImpl implements SaleRecordService {
    @Resource
    private SaleRecordMapper saleRecordDao;

}