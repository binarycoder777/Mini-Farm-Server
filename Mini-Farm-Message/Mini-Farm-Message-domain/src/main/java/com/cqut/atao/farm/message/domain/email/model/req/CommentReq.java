package com.cqut.atao.farm.message.domain.email.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName CommentReq.java
 * @Description 评论
 * @createTime 2023年04月19日 14:36:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentReq {

    private Long parentId;

    private Integer entityType;

    private Long fromId;

    private Long toId;

    private String content;

    private Integer status;
}
