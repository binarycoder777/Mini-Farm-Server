package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillNotice.java
 * @Description 秒杀提醒
 * @createTime 2023年04月17日 11:07:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class addKillNoticeReq {

    private Long userId;

    private Long spuId;

    private Long skuId;

    private Long killId;

    private Date killTime;

    private Integer noticeType;

}
