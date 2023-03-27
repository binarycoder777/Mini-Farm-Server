package com.cqut.atao.farm.product.domain.mq.comsume;

import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import com.cqut.atao.farm.product.domain.mq.event.ProductMessageSendEvent;
import com.cqut.atao.farm.product.domain.mq.messaging.MessageSink;
import com.cqut.atao.farm.product.domain.repository.ProductRepository;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailMessageSendConsume.java
 * @Description 邮箱消息发送消费者
 * @createTime 2023年01月11日 19:04:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class ProductMessageSendConsume {


    @Resource
    private ProductRepository productRepository;

    @StreamListener(MessageSink.PRODUCT_SEND)
    public void mailMessageSend(@Payload ProductMessageSendEvent productMessageSendEvent, @Headers Map headers) {
        long startTime = System.currentTimeMillis();
        try {
            // 1.构建信息
            EsProduct req = BeanUtil.convert(productMessageSendEvent.getEsProduct(), EsProduct.class);
            // 2.存储
            productRepository.saveEsProduct(req);
        } finally {
            log.info("Keys: {}, Msg id: {}, Execute time: {} ms, Message: {}", headers.get("rocketmq_KEYS"), headers.get("rocketmq_MESSAGE_ID"), System.currentTimeMillis() - startTime,
                    JSON.toJSONString(productMessageSendEvent));
        }
    }
}
