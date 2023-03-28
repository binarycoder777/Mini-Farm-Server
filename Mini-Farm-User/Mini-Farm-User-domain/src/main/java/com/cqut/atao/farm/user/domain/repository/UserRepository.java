package com.cqut.atao.farm.user.domain.repository;

import com.cqut.atao.farm.springboot.starter.convention.page.PageRequest;
import com.cqut.atao.farm.springboot.starter.convention.page.PageResponse;
import com.cqut.atao.farm.user.domain.model.req.CollectProductReq;
import com.cqut.atao.farm.user.domain.model.req.CommentProductReq;
import com.cqut.atao.farm.user.domain.model.res.LoginRes;
import com.cqut.atao.farm.user.domain.model.req.VxUserLoginReq;
import com.cqut.atao.farm.user.domain.model.res.ProductComment;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName IUserRepository.java
 * @Description 用户仓储层
 * @createTime 2023年01月12日 20:02:00
 */
public interface UserRepository {

    boolean checkUserInfoByOpenId(String openid);

    void addUser(VxUserLoginReq vxUserLoginVO);

    LoginRes getUserInfoByOpenId(String openid);

    void addCommentProduct(CommentProductReq req);

    PageResponse<ProductComment> pageProductComment(Long productId, PageRequest req);

    void saveCollectProduct(CollectProductReq req);

    boolean getCollectProductStatus(Long userId,Long productId);
}
