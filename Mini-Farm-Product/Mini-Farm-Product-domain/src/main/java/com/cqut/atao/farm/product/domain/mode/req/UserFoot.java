package com.cqut.atao.farm.product.domain.mode.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserFoot.java
 * @Description 用户足迹
 * @createTime 2023年04月14日 15:25:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFoot {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

}
