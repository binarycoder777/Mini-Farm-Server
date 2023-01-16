package com.cqut.atao.user.application.service;

import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressService.java
 * @Description 用户收货地址服务接口
 * @createTime 2023年01月13日 21:03:00
 */
public interface ReceiveAddressMange {

    List<ReceiveAddressVO> queryAddressList(String userId);

    void addReceiveAddress(ReceiveAddressVO receiveAddressVO);

}
