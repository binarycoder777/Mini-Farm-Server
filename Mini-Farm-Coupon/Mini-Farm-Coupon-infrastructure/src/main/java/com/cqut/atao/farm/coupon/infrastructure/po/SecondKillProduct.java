package com.cqut.atao.farm.coupon.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SecondKillProduct.java
 * @Description 参与秒杀的商品
 * @createTime 2023年03月14日 15:26:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("second_kill_products")
public class SecondKillProduct extends BaseDO {
    /**
     * id
     */
    private Long id;
    /**
     * 秒杀场次id
     */
    private Long killId;
    /**
     * 秒杀商品id
     */
    private Long productId;
    /**
     * 秒杀商品skuid
     */
    private Long productSkuId;
    /**
     * 秒杀价格
     */
    private BigDecimal killPrice;
    /**
     * 秒杀数量
     */
    private Integer killNum;

    /**
     * 审批状态
     */
    private Integer status;

}
