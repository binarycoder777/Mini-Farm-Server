package com.cqut.atao.farm.user.test;

import com.alibaba.fastjson.JSON;
import com.cqut.atao.farm.user.application.service.ReceiveAddressMange;
import com.cqut.atao.farm.user.domain.model.res.ReceiveAddressRes;
import com.cqut.atao.farm.user.domain.util.VxUtil;
import com.cqut.atao.farm.user.web.UserApplication;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ApiTest.java
 * @Description user api 测试
 * @createTime 2023年01月16日 19:46:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class ApiTest {

    @Autowired
    private ReceiveAddressMange receiveAddressMange;

    @Test
    public void testReceiveAddressMange() {
        List<ReceiveAddressRes> receiveAddressVOS = receiveAddressMange.queryAddressList("1547742028312375296");
        log.info("测试结果:{}",receiveAddressVOS);
    }

    @Test
    public void testJWT() {
        Claims claimByToken = VxUtil.getClaimByToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJ1c2VySWRcIjoxfSIsImlhdCI6MTY4MjM5NDczNCwiZXhwIjoxNjgyNDgxMTM0LCJpc3MiOiJNaW5pLUZhcm0ifQ.ZDsZ-lZh1KTkjikqhv8401OcsGFpPik-nzfc4KSjlsv5pXGoQ8VFDExp_c5DXhuIcObr6X-NdCWSpjcg092Kyg");
        log.info("{}", JSON.parseObject(claimByToken.getSubject()).get("userId"));
    }


}
