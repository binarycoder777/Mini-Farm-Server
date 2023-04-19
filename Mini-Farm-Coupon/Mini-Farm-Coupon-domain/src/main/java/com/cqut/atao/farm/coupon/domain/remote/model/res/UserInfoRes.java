package com.cqut.atao.farm.coupon.domain.remote.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserInfoRes.java
 * @Description 用户信息
 * @createTime 2023年02月23日 16:01:00
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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

