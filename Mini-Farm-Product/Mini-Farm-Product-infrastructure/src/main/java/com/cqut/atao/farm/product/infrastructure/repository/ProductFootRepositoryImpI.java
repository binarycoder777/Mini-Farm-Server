package com.cqut.atao.farm.product.infrastructure.repository;

import com.cqut.atao.farm.product.domain.mode.req.UserFoot;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductFootRepository;
import com.cqut.atao.farm.product.infrastructure.constant.RedisConstant;
import com.cqut.atao.farm.product.infrastructure.dao.ProductSpuDAO;
import com.cqut.atao.farm.product.infrastructure.po.ProductSpuPO;
import com.cqut.atao.farm.product.infrastructure.util.RedisUtil;
import com.cqut.atao.farm.springboot.starter.common.toolkit.BeanUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductFootRepositoryImpI.java
 * @Description 浏览足迹
 * @createTime 2023年04月14日 15:30:00
 */
@Repository
public class ProductFootRepositoryImpI implements ProductFootRepository {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private ProductSpuDAO productSpuDAO;

    @Override
    public void addUserFoot(UserFoot foot) {
        redisUtil.opsForSet(RedisConstant.USER_FOOT.getInfo()+foot.getUserId(),foot.getProductId()+"");
    }

    @Override
    public void deleteUserFoot(UserFoot foot) {
        redisUtil.opsForSetDel(RedisConstant.USER_FOOT.getInfo()+foot.getUserId(),foot.getProductId()+"");
    }

    @Override
    public List<ProductSpuVO> queryUserFoot(Long userId) {
        Set<Object> set = redisUtil.opsForSet(RedisConstant.USER_FOOT.getInfo()+userId);
        List<ProductSpuPO> res = Lists.newArrayList();
        set.forEach(e->{
            ProductSpuPO productSpuPO = productSpuDAO.selectById((String) e);
            res.add(productSpuPO);
        });
        return BeanUtil.convert(res,ProductSpuVO.class);
    }

}
