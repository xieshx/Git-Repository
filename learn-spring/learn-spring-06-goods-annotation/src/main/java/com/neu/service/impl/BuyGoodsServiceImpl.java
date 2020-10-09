package com.neu.service.impl;

import com.neu.dao.GoodsDao;
import com.neu.dao.SaleDao;
import com.neu.domain.Goods;
import com.neu.domain.Sale;
import com.neu.excep.NotEnoughException;
import com.neu.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("====buy_start===");
        // 记录销售信息
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        // 更新库存
        Goods goods = goodsDao.selectGoodByGid(goodsId);
        if (goods==null){
            //商品不存在
            throw new NullPointerException("编号："+goodsId+"商品不存在");
        }else if (goods.getAmount()<nums){
            //库存不足
            throw new NotEnoughException("编号："+goodsId+"商品库存不足");
        }
        //修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("====buy_end===");
    }
}
