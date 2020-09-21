package com.neu.service.impl;

import com.neu.dao.PurchaseMapper;
import com.neu.service.PurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 采购表(Purchase)表服务实现类
 *
 * @author makejava
 * @since 2020-09-19 21:50:27
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
    @Resource
    private PurchaseMapper purchaseDao;

}