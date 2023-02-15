package com.cqut.atao.farm.user.infrastructure.respository;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.cqut.atao.farm.springboot.starter.convention.exception.ServiceException;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.req.VxUserLoginReq;
import com.cqut.atao.farm.user.domain.repository.UserRepository;
import com.cqut.atao.farm.user.infrastructure.dao.UserDao;
import com.cqut.atao.farm.user.infrastructure.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description 用户仓储层
 * @createTime 2023年01月12日 20:03:00
 */
@Slf4j
@Repository
public class UserRepositoryImpI implements UserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public boolean checkUserInfoByOpenId(String openid) {
       return userDao.exists(new QueryWrapper<User>().lambda().eq(User::getOpenid,openid));
    }

    @Override
    public void addUser(VxUserLoginReq vxUserLoginVO) {
        User user = BeanUtil.convert(vxUserLoginVO,User.class);
        int res = userDao.insert(user);
        Assert.isTrue(res > 0 , () -> new ServiceException("新增用户信息失败") );
    }

    @Override
    public LoginRes getUserInfoByOpenId(String openid) {
        User user = userDao.selectOne(new QueryWrapper<User>().lambda().eq(User::getOpenid, openid));
        return BeanUtil.convert(user,LoginRes.class);
    }
}
