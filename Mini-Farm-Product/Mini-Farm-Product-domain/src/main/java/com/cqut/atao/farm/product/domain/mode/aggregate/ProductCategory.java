package com.cqut.atao.farm.product.domain.mode.aggregate;

import com.cqut.atao.farm.product.domain.mode.vo.ProductCategoryVO;
import lombok.*;

import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName ProductCategory.java
 * @Description 商品分类聚合类
 * @createTime 2023年01月31日 20:06:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class ProductCategory {
    /**
     * 商品分类信息
     */
    private List<ProductCategoryVO> productCategoryList;
}
