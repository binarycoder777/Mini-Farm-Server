package com.cqut.atao.farm.rocketmq.springboot.starter.constants;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MessageRocketMQConstants.java
 * @Description RocketMQ 常量
 * @createTime 2023年01月11日 18:59:00
 */
public class MessageRocketMQConstants {

    /**
     * 修改ES商品信息 TAG
     */
    public static final String UPDATE_ES_PRODUCT_TAG = "common_product-center_update-es-product-send_tag";

     * 邮箱消息发送 TAG
     */
    public static final String MESSAGE_MAIL_SEND_TAG = "common_message-center_mail-send_tag";

    /**
     * 支付消息发送 TAG
     */
    public static final String MESSAGE_PAY_SEND_TAG = "common_message-center_pay-send_tag";

    /**
     * 返还优惠消息发送 TAG
     */
    public static final String RETURN_SPECIAL_SEND_TAG = "common_message-center_return-special-send_tag";

}
