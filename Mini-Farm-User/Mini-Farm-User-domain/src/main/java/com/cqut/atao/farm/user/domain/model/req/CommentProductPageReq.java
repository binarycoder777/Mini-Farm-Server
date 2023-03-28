package com.cqut.atao.farm.user.domain.model.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentProductPageReq.java
 * @Description 评论商品分页请求
 * @createTime 2023年03月28日 09:00:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentProductPageReq extends PageRequest {

    /**
     * 商品ID
     */
    private Long productId;

}
