package com.cqut.atao.farm.message.domain.email.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformationRes.java
 * @Description 行业资讯结果
 * @createTime 2023年04月17日 09:39:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndustryInformationRes {

    private Long id;

    private Long createId;

    private String source;

    private String title;

    private String subTitle;

    private String pic;

    private String content;

    private Integer status;

}
