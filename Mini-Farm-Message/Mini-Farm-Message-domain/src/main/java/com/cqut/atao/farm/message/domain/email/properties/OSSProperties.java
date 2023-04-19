package com.cqut.atao.farm.message.domain.email.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {

	private String endPoint;
	private String bucketName;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketDomain;

}
