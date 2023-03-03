package com.cqut.atao.farm.pay.application.req;

import com.cqut.atao.farm.pay.domain.clearsystem.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RemitReq.java
 * @Description 结算请求
 * @createTime 2023年03月03日 13:44:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RemitReq {

    /**
     * 结算人id
     */
    private Long id;

    /**
     * 清分类型
     */
    private Constants.ClearingHandler clearingHandler;

    /**
     * 结算数据
     */
    private Object data;

}
