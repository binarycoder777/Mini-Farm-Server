package com.cqut.atao.farm.product.domain.mq.event;

import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mode.aggregate.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductMessageSendEvent.java
 * @Description 商品信息发送事件
 * @createTime 2023年03月27日 10:47:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductMessageSendEvent {

    /**
     * 消息发送id
     */
    private String messageSendId;

    /**
     * 商品信息
     */
    private EsProduct esProduct;

    /**
     * 状态 0：成功 1：失败
     */
    private Integer status;

    /**
     * 发送时间
     */
    private Date sendTime;

}
