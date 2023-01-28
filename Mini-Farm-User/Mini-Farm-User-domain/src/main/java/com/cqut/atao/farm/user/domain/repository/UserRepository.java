package com.cqut.atao.farm.user.domain.repository;

import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.vo.VxUserLoginVO;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IUserRepository.java
 * @Description 用户仓储层
 * @createTime 2023年01月12日 20:02:00
 */
public interface UserRepository {

    LoginRes checkUserInfo(String openid);

}
