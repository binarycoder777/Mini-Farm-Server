package com.cqut.atao.farm.message.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Comment.java
 * @Description 评论
 * @createTime 2023年04月19日 14:33:00
 */
@Data
@TableName("industry_comment")
public class Comment extends BaseDO {
    private Long id;

    private Long parentId;

    private Integer entityType;

    private Long fromId;

    private Long toId;

    private String content;

    private Integer status;

}
