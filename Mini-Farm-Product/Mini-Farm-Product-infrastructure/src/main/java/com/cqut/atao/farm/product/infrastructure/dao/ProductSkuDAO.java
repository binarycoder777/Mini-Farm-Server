package com.cqut.atao.farm.product.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderInfo;
import com.cqut.atao.farm.product.domain.mode.aggregate.OrderItemInfo;
import com.cqut.atao.farm.product.infrastructure.po.ProductSkuPO;
import org.apache.ibatis.annotations.Update;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductSkuDAO.java
 * @Description 商品 SKU 持久层
 * @createTime 2023年01月30日 16:17:00
 */
public interface ProductSkuDAO extends BaseMapper<ProductSkuPO> {

    @Update("update product_sku set stock = stock - #{num},lock_stock = lock_stock + #{num} where id = #{skuId} and stock - #{num} >= 0")
    int lockStock(OrderItemInfo itemInfo);

    @Update("update product_sku set stock = stock + #{num},lock_stock = lock_stock - #{num} where id = #{skuId} and lock_stock - #{num} >= 0")
    int unlockStock(OrderItemInfo itemInfo);


}
