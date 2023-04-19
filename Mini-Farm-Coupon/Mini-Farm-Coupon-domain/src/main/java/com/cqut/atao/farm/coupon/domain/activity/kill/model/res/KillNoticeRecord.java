package com.cqut.atao.farm.coupon.domain.activity.kill.model.res;

import lombok.Data;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillNoticeRecord.java
 * @Description 秒杀提醒记录
 * @createTime 2023年04月17日 13:49:00
 */
@Data
public class KillNoticeRecord {

    private Long userId;

    private Long spuId;

    private Long skuId;

    private Long killId;

    private Date killTime;

    private Integer noticeType;

}
