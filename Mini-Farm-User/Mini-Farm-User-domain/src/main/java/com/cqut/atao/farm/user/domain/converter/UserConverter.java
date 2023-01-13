package com.cqut.atao.farm.user.domain.converter;

import com.cqut.atao.farm.user.domain.model.vo.VxUserLoginVO;

import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserConverter.java
 * @Description 用户转换器
 * @createTime 2023年01月13日 20:39:00
 */
public class UserConverter {


    public static VxUserLoginVO conver(Map<String,String> data) {
        return new VxUserLoginVO();
    }

}
