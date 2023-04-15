package com.cqut.atao.farm.product.domain.mode.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PageCollectProductReq.java
 * @Description 分页查询收藏商品
 * @createTime 2023年04月10日 22:18:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageCollectProductReq extends PageRequest {

    /**
     * 用户ID
     */
    private Long userId;

}
