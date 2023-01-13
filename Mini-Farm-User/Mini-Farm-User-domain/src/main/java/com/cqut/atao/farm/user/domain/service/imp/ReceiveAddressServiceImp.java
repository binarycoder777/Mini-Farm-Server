package com.cqut.atao.farm.user.domain.service.imp;

import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;
import com.cqut.atao.farm.user.domain.repository.IReceiveAddressRepository;
import com.cqut.atao.farm.user.domain.service.ReceiveAddressService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressService.java
 * @Description 收货地址服务
 * @createTime 2023年01月13日 21:15:00
 */
public class ReceiveAddressServiceImp implements ReceiveAddressService {

    @Resource
    private IReceiveAddressRepository receiveAddressRepository;

    @Override
    public List<ReceiveAddressVO> queryList(String userId) {
        return receiveAddressRepository.queryList(userId);
    }
}
