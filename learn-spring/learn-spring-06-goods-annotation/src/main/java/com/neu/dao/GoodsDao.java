package com.neu.dao;


import com.neu.domain.Goods;

public interface GoodsDao {

    // 更新库存
    int updateGoods(Goods goods);

    // 查询商品信息
    Goods selectGoodByGid(Integer gid);
}
