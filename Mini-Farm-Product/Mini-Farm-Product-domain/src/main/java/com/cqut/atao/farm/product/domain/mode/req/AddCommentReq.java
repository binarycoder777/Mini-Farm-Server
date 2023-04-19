package com.cqut.atao.farm.product.domain.mode.req;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName AddCommentReq.java
 * @Description 新增评论请求
 * @createTime 2023年04月08日 13:59:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCommentReq {

    /**
     * id
     */
    private Long id;

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
     * 图片base64数组
     */
    private List<String> base64Pics;

    /**
     * 视频
     */
    private String video;

    public void convertToStr() {
        if (base64Pics == null || base64Pics.size() == 0) {
           return;
        }
        pics = "";
        for (int i=0;i<base64Pics.size()-1;++i) {
            pics = pics + base64Pics.get(i) + "、";
        }
        pics = pics + base64Pics.get(base64Pics.size()-1);
    }

    public void convertToList() {
        String[] split = pics.split("、");
        if (split.length == 0) {
            return;
        }
        if (base64Pics == null) {
            base64Pics = Lists.newArrayList();
        }
        for (String s: split) {
            base64Pics.add(s);
        }
    }

}
