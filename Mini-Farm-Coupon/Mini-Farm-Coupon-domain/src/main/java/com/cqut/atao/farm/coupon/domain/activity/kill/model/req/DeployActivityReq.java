package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class DeployActivityReq {

    private Long id;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 活动状态
     */
    private Integer status;
}
