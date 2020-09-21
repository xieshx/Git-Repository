package com.neu.dao;

import com.neu.pojo.Operator;

public interface OperatorMapper {
    int deleteByPrimaryKey(Integer operatorId);

    int insert(Operator record);

    int insertSelective(Operator record);

    Operator selectByPrimaryKey(Integer operatorId);

    int updateByPrimaryKeySelective(Operator record);

    int updateByPrimaryKey(Operator record);
}