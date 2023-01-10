package com.cqut.atao.farm.message.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cqut.atao.farm.message.infrastructure.po.MailSendRecordPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailSendRecordDAO.java
 * @Description 邮件发送记录 dao
 * @createTime 2023年01月10日 16:39:00
 */
@Mapper
public interface MailSendRecordDAO extends BaseMapper<MailSendRecordPO> {
}
