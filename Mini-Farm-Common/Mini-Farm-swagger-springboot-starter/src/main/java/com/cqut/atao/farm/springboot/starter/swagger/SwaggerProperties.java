package com.cqut.atao.farm.springboot.starter.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName SwaggerProperties.java
 * @Description Swagger 配置
 * @createTime 2023年01月11日 15:18:00
 */
@Data
@ConfigurationProperties("farm.swagger")
public class SwaggerProperties {

    private Boolean enabled;

    private String basePackage = "";

    private String title = "";

    private String groupName = "";

    private String description = "";

    private String version = "";

    private String host = "";

    private String license = "";

    private String licenseUrl = "";

    private String termsOfServiceUrl = "";

    private List<String> basePath = new ArrayList();

    private List<String> excludePath = new ArrayList();

    private Contact contact = new Contact();

    private Authorization authorization = new Authorization();

    @Data
    @NoArgsConstructor
    public static class Contact {

        private String name = "";

        private String url = "";

        private String email = "";
    }

    @Data
    @NoArgsConstructor
    public static class Authorization {

        private String name = "";

        private String authRegex = "^.*$";

        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();

        private List<String> tokenUrlList = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    public static class AuthorizationScope {

        private String scope = "";

        private String description = "";
    }
}

