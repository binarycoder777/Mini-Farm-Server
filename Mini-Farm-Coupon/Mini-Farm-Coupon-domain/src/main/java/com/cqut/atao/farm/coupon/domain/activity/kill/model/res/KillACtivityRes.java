package com.cqut.atao.farm.coupon.domain.activity.kill.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillACtivityRes.java
 * @Description 秒杀活动场次
 * @createTime 2023年04月10日 19:04:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KillACtivityRes {
    /**
     * id
     */
    private String id;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

    private Integer status;

}
