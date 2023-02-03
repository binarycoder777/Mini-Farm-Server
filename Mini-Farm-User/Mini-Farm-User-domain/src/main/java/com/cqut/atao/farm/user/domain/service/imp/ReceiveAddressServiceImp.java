package com.cqut.atao.farm.user.domain.service.imp;

import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;
import com.cqut.atao.farm.user.domain.repository.ReceiveAddressRepository;
import com.cqut.atao.farm.user.domain.service.ReceiveAddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressService.java
 * @Description 收货地址服务
 * @createTime 2023年01月13日 21:15:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class ReceiveAddressServiceImp implements ReceiveAddressService {

    @Autowired
    private ReceiveAddressRepository receiveAddressRepository;

    @Override
    public List<ReceiveAddressVO> queryList(String userId) {
        return receiveAddressRepository.queryList(userId);
    }

    @Override
    public void saveReceiveAddress(ReceiveAddressVO receiveAddressVO) {
        receiveAddressRepository.saveReceiveAddress(receiveAddressVO);
    }

    @Override
    public void deleteReceiveAddress(String req) {
        receiveAddressRepository.deleteReceiveAddress(req);
    }
}
