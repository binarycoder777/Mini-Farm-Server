package com.cqut.atao.farm.message.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IndustryInformation.java
 * @Description 行业资讯
 * @createTime 2023年04月17日 09:31:00
 */
@Data
@TableName("industry_information")
public class IndustryInformation extends BaseDO {

    private Long id;

    private Long createId;

    private String source;

    private String title;

    private String subTitle;

    private String pic;

    private String content;

    private Integer status;

}
