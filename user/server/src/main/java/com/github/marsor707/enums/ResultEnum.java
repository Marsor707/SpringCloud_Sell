package com.github.marsor707.enums;

import lombok.Getter;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Getter
public enum ResultEnum {
    LOGIN_FAIL(1, "登陆失败"),
    ROLE_ERROR(2, "角色权限有误");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
