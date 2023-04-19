package com.cqut.atao.farm.product.domain.mode.res;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentRes.java
 * @Description 评论
 * @createTime 2023年04月09日 10:51:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRes {

    /**
     * id
     */
    private Long id;

    /**
     * 评论类型（好评、差评等）
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * sku id
     */
    private Long productSkuId;

    /**
     * sku 对应规格
     */
    private String spec;

    /**
     * 商品评分
     */
    private Integer star;

    /**
     * 态度评分
     */
    private Integer attitude;
    /**
     * 物流评分
     */
    private Integer logistics;
    /**
     * 速度评分
     */
    private Integer speed;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 是否匿名
     */
    private boolean hideFlag;

    /**
     * 图片
     */
    private String pics;

    /**
     * 视频
     */
    private String video;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String face;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 评论图片
     */
    private List<String> img;

    public void convertToList() {
        String[] split = pics.split("、");
        if (split.length == 0) {
            return;
        }
        if (img == null) {
            img = Lists.newArrayList();
        }
        for (String s: split) {
            img.add(s);
        }
    }

}
