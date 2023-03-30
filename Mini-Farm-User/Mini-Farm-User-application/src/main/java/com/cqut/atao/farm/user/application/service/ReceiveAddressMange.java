package com.cqut.atao.farm.user.application.service;

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
public interface ReceiveAddressMange {

    /**
     * 获取用户默认收货地址
     * @param userId 用户id
     * @return {@link ReceiveAddressRes}
     */
    ReceiveAddressRes defaultAddress(Long userId);

    /**
     * 查询收货地址列表
     * @param userId 用户id
     * @return {@link List}
     */
    List<ReceiveAddressRes> queryAddressList(String userId);

    /**
     * 新增/保存收货地址
     * @param req
     */
    void saveReceiveAddress(ReceiveAddressReq req);

    /**
     * 删除收货地址
     * @param id
     */
    void deleteReceiveAddress(String id);

}
