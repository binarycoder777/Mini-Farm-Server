package com.cqut.atao.farm.product.domain.mode.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PageCommentReq.java
 * @Description 评论分页查询请求
 * @createTime 2023年04月09日 10:44:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageCommentReq extends PageRequest {

    private Long productSpuId;

    private Integer type;

}
