package com.cqut.atao.user.infrastructure.respository;

import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.vo.VxUserLoginVO;
import com.cqut.atao.farm.user.domain.repository.IUserRepository;
import com.cqut.atao.user.infrastructure.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description 用户仓储层
 * @createTime 2023年01月12日 20:03:00
 */
public class UserRepository implements IUserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public LoginRes checkUserInfo(VxUserLoginVO vxUserLoginVO) {
        // 1.校验是否存在该用户
        // 2.查询返回用户基本信息
        return new LoginRes();
    }
}
