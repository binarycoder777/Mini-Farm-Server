package com.cqut.atao.farm.coupon.domain.remote.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author atao
 * @version 1.0.0
 * @ClassName MailSendReq.java
 * @Description 邮件发送请求
 * @createTime 2023年01月11日 15:12:00
 */
@Builder
@Data
@ApiModel("邮箱发送")
public class MailMessageSendReq {

    @ApiModelProperty(value = "标题", example = "邮箱验证码提醒")
    @NotBlank(message = "邮箱标题不能为空")
    private String title;

    @Email
    @ApiModelProperty(value = "发送者", example = "18325061670@163.com")
    @NotBlank(message = "邮箱发送者不能为空")
    private String sender;

    @Email
    @ApiModelProperty(value = "接收者", example = "87337334@qq.com", notes = "实际发送时更改为自己邮箱")
    @NotBlank(message = "邮箱接收者不能为空")
    private String receiver;

    @Email
    @ApiModelProperty("抄送者")
    private String cc;

    @ApiModelProperty(value = "消息参数")
    private List<String> paramList;

    @ApiModelProperty(value = "模板ID", example = "userRegisterVerification")
    @NotBlank(message = "邮箱模板ID不能为空")
    private String templateId;

}
