package com.cqut.atao.farm.springboot.starter.distributedid.core.serviceid;

import com.cqut.atao.farm.springboot.starter.distributedid.core.IdGenerator;
import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.SnowflakeIdInfo;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ServiceIdGenerator.java
 * @Description 业务 ID 生成器
 * @createTime 2023年01月10日 20:15:00
 */
public interface ServiceIdGenerator extends IdGenerator {

    /**
     * 根据 {@param bizId} 生成雪花算法 ID
     */
    long nextId(long serviceId);

    /**
     * 解析雪花算法
     */
    SnowflakeIdInfo parseSnowflakeId(long snowflakeId);
}
