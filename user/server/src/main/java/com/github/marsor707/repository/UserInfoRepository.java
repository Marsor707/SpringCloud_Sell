package com.github.marsor707.repository;

import com.github.marsor707.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Marsor
 * Github: https://github.com/Marsor707
 * Email: 369135912@qq.com
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
