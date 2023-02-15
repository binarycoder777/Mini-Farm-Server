package com.cqut.atao.farm.product.application.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;


/**
 * @author atao
 * @version 1.0.0
 * @ClassName ElasticsearchConfig.java
 * @Description ES配置类
 * @createTime 2023年02月11日 19:11:00
 */
@ConfigurationProperties(prefix = "elasticsearch")
@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    private String host ;

    private Integer port ;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port));
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }


}
