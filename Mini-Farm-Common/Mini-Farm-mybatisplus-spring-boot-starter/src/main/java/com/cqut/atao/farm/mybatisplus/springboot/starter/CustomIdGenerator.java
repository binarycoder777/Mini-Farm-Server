package com.cqut.atao.farm.mybatisplus.springboot.starter;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.cqut.atao.farm.springboot.starter.distributedid.SnowflakeIdUtil;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CustomIdGenerator.java
 * @Description 自定义雪花算法生成器
 * @createTime 2023年01月10日 18:25:00
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdUtil.nextId();
    }
}
