package com.cqut.atao.farm.user.domain.service;

import com.cqut.atao.farm.user.domain.model.req.ReceiveAddressReq;
import com.cqut.atao.farm.user.domain.model.res.ReceiveAddressRes;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressService.java
 * @Description 用户收货地址服务接口
 * @createTime 2023年01月13日 21:03:00
 */
public interface ReceiveAddressService {

    List<ReceiveAddressRes> queryList(String userId);

    void saveReceiveAddress(ReceiveAddressReq req);

    void deleteReceiveAddress(String id);
}
