package com.neu.dao;

import com.neu.pojo.SaleRecord;

public interface SaleRecordMapper {
    int deleteByPrimaryKey(String listId);

    int insert(SaleRecord record);

    int insertSelective(SaleRecord record);

    SaleRecord selectByPrimaryKey(String listId);

    int updateByPrimaryKeySelective(SaleRecord record);

    int updateByPrimaryKey(SaleRecord record);
}