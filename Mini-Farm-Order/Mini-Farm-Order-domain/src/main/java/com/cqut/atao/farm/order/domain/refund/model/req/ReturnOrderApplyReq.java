package com.cqut.atao.farm.order.domain.refund.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReturnOrderApplyReq.java
 * @Description 退还订单申请请求
 * @createTime 2023年04月23日 14:37:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnOrderApplyReq {

    /**
     * 订单号
     */
    private String orderSn;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 退款金额
     */
    private BigDecimal returnAmount;

    /**
     * 退款状态
     */
    private Integer status;

    /**
     * 退款原因
     */
    private String reason;

    /**
     * 图片描述
     */
    private String descPics;

    private List<String> pics;

    public void picToStr() {
        descPics = "";
        pics.forEach(e->{
            descPics = descPics + e + "、";
        });
    }

}
