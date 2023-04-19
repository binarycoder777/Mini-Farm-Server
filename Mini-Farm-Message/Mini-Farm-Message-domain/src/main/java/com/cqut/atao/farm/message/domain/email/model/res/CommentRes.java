package com.cqut.atao.farm.message.domain.email.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class CommentRes {

    private Long parentId;

    private Integer entityType;

    private Long fromId;

    private Long toId;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Data createTime;

    private Integer replyCount;

    /**
     * 子评论
     */
    private List<ChildCommentRes> childCommentRes;

}
