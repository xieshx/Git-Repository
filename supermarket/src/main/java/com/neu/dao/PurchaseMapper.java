package com.neu.dao;

import com.neu.pojo.Purchase;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer puchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer puchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
}