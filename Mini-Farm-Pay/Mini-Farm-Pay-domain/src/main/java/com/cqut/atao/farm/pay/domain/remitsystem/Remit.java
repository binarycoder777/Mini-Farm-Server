package com.cqut.atao.farm.pay.domain.remitsystem;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName Remit.java
 * @Description 结算接口
 * @createTime 2023年03月03日 11:26:00
 */
public interface Remit {

    /**
     * 结算
     * @param id 结算对应账号id
     */
    void remit(Long id);

}
