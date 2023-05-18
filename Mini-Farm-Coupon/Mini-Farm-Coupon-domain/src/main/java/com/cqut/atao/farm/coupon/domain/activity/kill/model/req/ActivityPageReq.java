package com.cqut.atao.farm.coupon.domain.activity.kill.model.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ActivityPageReq.java
 * @Description 活动分页请求
 * @createTime 2023年04月30日 18:12:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityPageReq extends PageRequest {
    private Long id;
}
