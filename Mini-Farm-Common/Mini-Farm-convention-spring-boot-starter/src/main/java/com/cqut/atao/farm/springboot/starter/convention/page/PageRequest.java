package com.cqut.atao.farm.springboot.starter.convention.page;

import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName PageRequest.java
 * @Description 分页请求对象
 * @createTime 2023年01月10日 18:51:00
 */
@Data
public class PageRequest {

    /**
     * 当前页
     */
    private Long current;

    /**
     * 每页显示条数
     */
    private Long size;
}
