package com.cqut.atao.farm.order.domain.model.req;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReturnProductReq.java
 * @Description 退货请求
 * @createTime 2023年04月10日 14:25:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReturnProductReq {

    @ApiModelProperty("订单号")
    private String orderSn;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("退款原因")
    private String refundReason;

    @ApiModelProperty("图片")
    private List<String> pics;

    private String refundPic;

    public void picToStr() {
        refundPic = "";
        pics.forEach(e->{
            refundPic = refundPic + e + "、";
        });
    }
}
