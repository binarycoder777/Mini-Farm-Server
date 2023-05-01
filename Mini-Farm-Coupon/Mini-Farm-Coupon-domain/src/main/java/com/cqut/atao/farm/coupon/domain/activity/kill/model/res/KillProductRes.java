package com.cqut.atao.farm.coupon.domain.activity.kill.model.res;

import com.cqut.atao.farm.coupon.domain.remote.model.res.Product;
import com.cqut.atao.farm.coupon.domain.remote.model.res.ProductSpuVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillProductRes.java
 * @Description 秒杀商品
 * @createTime 2023年04月16日 11:15:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KillProductRes {

    private String killProductId;

    private BigDecimal price;

    private Integer killNum;

    private Integer status;

    private Long productId;

    private Long productSkuId;

    private Product product;

}
