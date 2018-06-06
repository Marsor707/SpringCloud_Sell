package com.github.marsor707.enums;

import lombok.Getter;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家");

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
