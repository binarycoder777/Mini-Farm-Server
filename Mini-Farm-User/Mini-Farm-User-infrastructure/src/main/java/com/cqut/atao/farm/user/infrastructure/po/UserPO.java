package com.cqut.atao.farm.user.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cqut.atao.farm.mybatisplus.springboot.starter.BaseDO;
import lombok.Data;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserPO.java
 * @Description 用户数据对象
 * @createTime 2023年01月12日 19:57:00
 */
@Data
@TableName("customer_user")
public class UserPO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * 微信唯一标识
     */
    private String openId;

    /**
     * 昵称
     */
    private String name;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;
}
