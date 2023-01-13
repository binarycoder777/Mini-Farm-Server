package com.cqut.atao.user.application.service.imp;

import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;
import com.cqut.atao.farm.user.domain.service.ReceiveAddressService;
import com.cqut.atao.user.application.service.ReceiveAddressMange;
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
@Service
public class ReceiveAddressMangeImp implements ReceiveAddressMange {

    @Resource
    private ReceiveAddressService receiveAddressService;

    public List<ReceiveAddressVO> queryAddressList(String userId) {
        return receiveAddressService.queryList(userId);
    }
}
