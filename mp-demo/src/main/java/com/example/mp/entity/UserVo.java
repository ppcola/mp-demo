package com.example.mp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xi
 * @create 2024/4/3 12:31
 */
@Data
@Schema(description = "用户表单实体")
public class UserVo {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "注册手机号")
    private String phone;

    @Schema(description = "详细信息，JSON风格")
    private String info;

    @Schema(description = "账户余额")
    private Integer balance;
}
