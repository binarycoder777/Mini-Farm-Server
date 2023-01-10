package com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.choose;

import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.AbstractWorkIdChooseTemplate;
import com.cqut.atao.farm.springboot.starter.distributedid.core.snowflake.wrapper.WorkIdWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName RandomWorkIdChoose.java
 * @Description 使用随机数获取雪花 WorkId
 * @createTime 2023年01月10日 20:13:00
 */
@Slf4j
public class RandomWorkIdChoose extends AbstractWorkIdChooseTemplate implements InitializingBean {

    @Override
    protected WorkIdWrapper chooseWorkId() {
        int start = 0, end = 31;
        return new WorkIdWrapper(getRandom(start, end), getRandom(start, end));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        chooseAndInit();
    }

    private static long getRandom(int start, int end) {
        long random = (long) (Math.random() * (end - start + 1) + start);
        return random;
    }
}
