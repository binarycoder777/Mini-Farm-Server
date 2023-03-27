package com.cqut.atao.farm.user.application.service.imp;

import com.cqut.atao.farm.user.application.service.ReceiveAddressMange;
import com.cqut.atao.farm.user.domain.model.req.ReceiveAddressReq;
import com.cqut.atao.farm.user.domain.model.res.ReceiveAddressRes;
import com.cqut.atao.farm.user.domain.service.ReceiveAddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressServiceImp.java
 * @Description 用户收货地址服务
 * @createTime 2023年01月13日 21:04:00
 */
@Slf4j
@Service
@AllArgsConstructor
public class ReceiveAddressMangeImp implements ReceiveAddressMange {

    @Resource
    private ReceiveAddressService receiveAddressService;

    @Override
    public List<ReceiveAddressRes> queryAddressList(String userId) {
        return receiveAddressService.queryList(userId);
    }

    @Override
    public void saveReceiveAddress(ReceiveAddressReq req) {
        receiveAddressService.saveReceiveAddress(req);
    }

    @Override
    public void deleteReceiveAddress(String id) {
        receiveAddressService.deleteReceiveAddress(id);
    }
}
