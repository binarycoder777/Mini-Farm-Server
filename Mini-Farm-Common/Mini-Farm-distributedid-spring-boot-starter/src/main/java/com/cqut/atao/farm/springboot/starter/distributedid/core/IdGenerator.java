package com.cqut.atao.farm.springboot.starter.distributedid.core;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IdGenerator.java
 * @Description ID 生成器
 * @createTime 2023年01月10日 20:04:00
 */
public interface IdGenerator {

    /**
     * 下一个 ID
     */
    default long nextId() {
        return 0L;
    }

    /**
     * 下一个 ID 字符串
     */
    default String nextIdStr() {
        return "";
    }

}
