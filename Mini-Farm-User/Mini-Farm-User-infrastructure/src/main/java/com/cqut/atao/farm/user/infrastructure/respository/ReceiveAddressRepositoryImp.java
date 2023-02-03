package com.cqut.atao.farm.user.infrastructure.respository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.user.domain.model.vo.ReceiveAddressVO;
import com.cqut.atao.farm.user.domain.repository.ReceiveAddressRepository;
import com.cqut.atao.farm.user.infrastructure.po.ReceiveAddressPO;
import com.cqut.atao.farm.user.infrastructure.dao.ReceiveAddressDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ReceiveAddressRepository.java
 * @Description 收货地址仓储实现
 * @createTime 2023年01月13日 21:20:00
 */
@Repository
@AllArgsConstructor
public class ReceiveAddressRepositoryImp implements ReceiveAddressRepository {

    @Resource
    private ReceiveAddressDao receiveAddressDao;

    @Override
    public List<ReceiveAddressVO> queryList(String userId) {
        List<ReceiveAddressPO> receiveAddressPOS = receiveAddressDao.selectList(new QueryWrapper<ReceiveAddressPO>().lambda().eq(ReceiveAddressPO::getCustomerUserId, userId));
        List<ReceiveAddressVO> receiveAddressVOS = BeanUtil.copyToList(receiveAddressPOS, ReceiveAddressVO.class);
        return receiveAddressVOS;
    }

    @Override
    public void saveReceiveAddress(ReceiveAddressVO receiveAddressVO) {
        if (StringUtils.isNotBlank(receiveAddressVO.getId()) && receiveAddressDao.exists(Wrappers.lambdaQuery(ReceiveAddressPO.class).eq(ReceiveAddressPO::getId,receiveAddressVO.getId()))) {
            int res = receiveAddressDao.update(BeanUtil.toBean(receiveAddressVO,ReceiveAddressPO.class),Wrappers.lambdaQuery(ReceiveAddressPO.class).eq(ReceiveAddressPO::getId,receiveAddressVO.getId()));
            Assert.isTrue(res > 0, () -> new ServiceException("修改收货地址失败"));
            return;
        }
        int res = receiveAddressDao.insert(BeanUtil.toBean(receiveAddressVO,ReceiveAddressPO.class));
        Assert.isTrue(res > 0, () -> new ServiceException("新增收货地址失败"));
    }

    @Override
    public void deleteReceiveAddress(String req) {
        int res = receiveAddressDao.delete(Wrappers.lambdaQuery(ReceiveAddressPO.class).eq(ReceiveAddressPO::getId,req));
        Assert.isTrue(res > 0, () -> new ServiceException("删除收货地址失败"));
    }
}
