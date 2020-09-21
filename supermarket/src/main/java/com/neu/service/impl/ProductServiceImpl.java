package com.neu.service.impl;

import com.neu.dao.ProductMapper;
import com.neu.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品表(Product)表服务实现类
 *
 * @author makejava
 * @since 2020-09-19 21:50:27
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productDao;


}