package com.cqut.atao.farm.user.domain.service.imp;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.user.common.constant.Constants;
import com.cqut.atao.farm.user.domain.model.req.BaseLoginReq;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.res.ProductComment;
import com.cqut.atao.farm.user.domain.repository.UserRepository;
import com.cqut.atao.farm.user.domain.service.UserService;
import com.cqut.atao.farm.user.domain.strategy.LoginContext;
import com.cqut.atao.farm.user.domain.strategy.LoginStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName UserServiceImp.java
 * @Description 用户服务
 * @createTime 2023年01月12日 20:08:00
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserServiceImp implements UserService {

    @Resource
    private Map<Constants.LoginStrategy, LoginStrategy> loginStrategy;

    @Resource
    private UserRepository userRepository;

    @Override
    public LoginRes login(BaseLoginReq req) {
        LoginRes res = null;
        // 1.获取登录类型
        String loginType = req.getLoginType();
        // 2.登录验证
        if (loginType.equals("VX")) {
            res = loginStrategy.get(Constants.LoginStrategy.VX).login(req);
        }
        // 3.策略模式进行登录
        return res;
    }

    @Override
    public void collectProduct(CollectProductReq req) {
        if (req.getId() == null) {
            // 新增
            userRepository.addCollectProduct(req);
            return;
        }
        // 修改
        userRepository.updateCollectProduct(req);
    }

    @Override
    public void commentProduct(CommentProductReq req) {
        userRepository.addCommentProduct(req);
    }

    @Override
    public PageResponse<ProductComment> productCommentPage(Long productId, PageRequest req) {
        return userRepository.pageProductComment(productId,req);
    }
}
