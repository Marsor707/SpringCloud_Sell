package com.github.marsor707.service;

import com.github.marsor707.dataobject.UserInfo;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
