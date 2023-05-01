package com.cqut.atao.farm.order.domain.model.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName TimeQuantum.java
 * @Description 时间段
 * @createTime 2023年05月01日 19:57:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeQuantum {


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;
}
