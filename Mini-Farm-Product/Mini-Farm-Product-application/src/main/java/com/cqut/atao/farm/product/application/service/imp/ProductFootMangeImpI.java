package com.cqut.atao.farm.product.application.service.imp;

import com.cqut.atao.farm.product.application.service.ProductFootMange;
import com.cqut.atao.farm.product.domain.mode.req.UserFoot;
import com.cqut.atao.farm.product.domain.mode.vo.ProductSpuVO;
import com.cqut.atao.farm.product.domain.repository.ProductFootRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductFootMangeImpI.java
 * @Description 用户商品足迹
 * @createTime 2023年04月14日 16:12:00
 */
@Service
public class ProductFootMangeImpI implements ProductFootMange {

    @Resource
    private ProductFootRepository productFootRepository;

    @Override
    public List<ProductSpuVO> productFootList(Long userId) {
        return productFootRepository.queryUserFoot(userId);
    }

    @Override
    public void addUserFoot(UserFoot foot) {
        productFootRepository.addUserFoot(foot);
    }

    @Override
    public void deleteUserFoot(UserFoot foot) {
        productFootRepository.deleteUserFoot(foot);
    }
}
