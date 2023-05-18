package com.cqut.atao.farm.coupon.application.admin.model;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ListReq.java
 * @Description 列表请求
 * @createTime 2023年04月30日 09:46:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListReq extends PageRequest {
    private String name;

    private Integer type;
}
