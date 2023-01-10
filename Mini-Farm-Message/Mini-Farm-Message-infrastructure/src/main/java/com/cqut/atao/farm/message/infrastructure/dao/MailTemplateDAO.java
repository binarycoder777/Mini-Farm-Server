package com.cqut.atao.farm.message.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.message.infrastructure.po.MailTemplatePO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailTemplateDAO.java
 * @Description 邮件模板dao
 * @createTime 2023年01月10日 16:38:00
 */
@Mapper
public interface MailTemplateDAO extends BaseMapper<MailTemplatePO> {

}
