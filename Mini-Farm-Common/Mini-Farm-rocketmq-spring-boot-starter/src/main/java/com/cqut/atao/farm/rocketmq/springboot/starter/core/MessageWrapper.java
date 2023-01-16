package com.cqut.atao.farm.rocketmq.springboot.starter.core;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageWrapper.java
 * @Description 消息体包装器
 * @createTime 2023年01月16日 10:36:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public final class MessageWrapper<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息发送Keys
     */
    @NonNull
    private String keys;

    /**
     * 消息体
     */
    @NonNull
    private T message;

    /**
     * 唯一标识，用于客户端幂等验证
     */
    private String uuid = UUID.randomUUID().toString();

    /**
     * 消息发送时间
     */
    private Long timestamp = System.currentTimeMillis();
}
