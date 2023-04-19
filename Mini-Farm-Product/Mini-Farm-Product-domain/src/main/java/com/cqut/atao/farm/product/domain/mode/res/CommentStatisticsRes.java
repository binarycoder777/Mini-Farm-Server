package com.cqut.atao.farm.product.domain.mode.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentType.java
 * @Description 评论统计结果
 * @createTime 2023年04月08日 22:51:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentStatisticsRes {

    /**
     * 标签名
     */
    private String name;

    /**
     * 评论总数
     */
    private Long number;

    /**
     * 评论类型（all、1：good、2：secondary、3：poor、4：img、5：video、6：append）
     */
    private String type;

}
