package com.cqut.atao.farm.product.infrastructure.es;

import com.cqut.atao.farm.product.domain.mode.aggregate.EsProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName EsProductDAO.java
 * @Description product的ES访问dao
 * @createTime 2023年02月15日 19:03:00
 */
@Repository
public interface EsProductDAO extends ElasticsearchRepository<EsProduct,String> {

}

