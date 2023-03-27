package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName DeployReq.java
 * @Description 部署请求
 * @createTime 2023年03月14日 21:06:00
 */
@Data
@Builder
public class DeployActivityReq {

    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

}
