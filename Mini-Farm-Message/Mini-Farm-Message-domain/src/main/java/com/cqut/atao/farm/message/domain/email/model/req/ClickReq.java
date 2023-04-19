package com.cqut.atao.farm.message.domain.email.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ClickReq.java
 * @Description 资讯点击（点击 == 阅读）
 * @createTime 2023年04月19日 14:09:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClickReq {
    private Long targetId;
}
