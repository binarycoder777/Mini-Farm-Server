package com.cqut.atao.farm.user.domain.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CollectProductReq.java
 * @Description 收藏商品请求
 * @createTime 2023年03月27日 17:20:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectProductReq {

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
