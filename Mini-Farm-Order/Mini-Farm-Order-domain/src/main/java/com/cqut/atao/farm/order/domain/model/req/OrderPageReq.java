package com.cqut.atao.farm.order.domain.model.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName OrderPageReq.java
 * @Description 订单分页请求
 * @createTime 2023年03月31日 08:49:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPageReq extends PageRequest {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 前端订单状态码
     */
    private Integer frontOrderStatus;

    /**
     * 后端订单状态码
     */
    private Integer orderStatus;
}
