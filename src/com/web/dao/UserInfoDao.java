package com.web.dao;

import com.web.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    UserInfo getUserInfoByUserNameAndPassword(String userName,String password);

    List<UserInfo> getUserAll();
}
