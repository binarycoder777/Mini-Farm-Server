package com.cqut.atao.farm.coupon.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName KillsInSeconds.java
 * @Description 秒杀场次
 * @createTime 2023年03月14日 15:22:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("kills_in_seconds")
public class KillsInSeconds extends BaseDO {

    /**
     * id
     */
    private Long id;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

}
