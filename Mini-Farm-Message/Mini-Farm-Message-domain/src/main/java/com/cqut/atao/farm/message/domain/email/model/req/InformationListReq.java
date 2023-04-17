package com.cqut.atao.farm.message.domain.email.model.req;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName InformationListReq.java
 * @Description 行业资讯列表请求
 * @createTime 2023年04月17日 09:42:00
 */
@Builder
@Data
@AllArgsConstructor
public class InformationListReq extends PageRequest {

}
