package com.cqut.atao.farm.user.domain.repository;

import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressRepository.java
 * @Description 收货地址仓储层
 * @createTime 2023年01月13日 21:18:00
 */
public interface IReceiveAddressRepository {

    public List<ReceiveAddressVO> queryList(String userId);

}
