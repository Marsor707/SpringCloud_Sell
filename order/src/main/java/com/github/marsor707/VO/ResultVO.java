package com.github.marsor707.VO;

import lombok.Data;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
