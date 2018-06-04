package com.github.marsor707.enums;

import lombok.Getter;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Getter
public enum ResultEnum {
    PARAMS_ERROR(1, "参数不正确"),
    CART_EMPTY(2, "购物车为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
