package com.cqut.atao.farm.product.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserCollection.java
 * @Description 用户商品收藏实体类
 * @createTime 2023年03月27日 17:10:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product_collection")
public class ProductCollectionPO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * userId
     */
    private Long userId;

    /**
     * productId
     */
    private Long productId;

    /**
     * 收藏状态
     */
    private boolean status;

}
