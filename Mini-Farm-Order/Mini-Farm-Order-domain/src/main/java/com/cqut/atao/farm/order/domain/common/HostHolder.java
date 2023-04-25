package com.cqut.atao.farm.order.domain.common;

import com.cqut.atao.farm.order.domain.remote.model.res.UserInfoRes;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息,用于代替session对象.
 */
@Component
public class HostHolder {

    private ThreadLocal<UserInfoRes> users = new ThreadLocal<>();

    public void setUser(UserInfoRes user) {
        users.set(user);
    }

    public UserInfoRes getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
