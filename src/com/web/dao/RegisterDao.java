package com.web.dao;

import com.web.entity.UserDetailInfo;
import com.web.entity.UserInfo;

public interface RegisterDao {
    boolean register(UserInfo userInfo);
    boolean isCheckUserName(UserInfo userInfo);

    boolean register1(UserDetailInfo userDetailInfo);

}
