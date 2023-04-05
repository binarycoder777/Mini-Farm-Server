package com.cqut.atao.farm.order.domain.remote.model.res;

import lombok.Builder;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserInfoRes.java
 * @Description 用户信息
 * @createTime 2023年04月04日 15:45:00
 */
@Data
@Builder
public class UserInfoRes {

    /**
     * id
     */
    private Long id;

    /**
     * 微信唯一标识
     */
    private String openid;

    /**
     * 昵称
     */
    private String name;

    /**
     * 账号
     */
    private String number;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

}


