package com.cqut.atao.farm.message.domain.email.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ChintRes.java
 * @Description zi'ping自评率
 * @createTime 2023年04月19日 14:48:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildCommentRes {
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
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 被评论的人
     */
    private String parentNickName;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Data createTime;
}
