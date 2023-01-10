package com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName WorkIdWrapper.java
 * @Description WorkId 包装器
 * @createTime 2023年01月10日 20:06:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkIdWrapper {

    /**
     * 工作ID
     */
    private Long workId;

    /**
     * 数据中心ID
     */
    private Long dataCenterId;
}
