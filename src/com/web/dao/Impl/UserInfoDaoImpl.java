package com.web.dao.Impl;

import com.web.dao.UserInfoDao;
import com.web.entity.UserInfo;
import com.web.utils.BaseDao2;

import java.util.List;

public class UserInfoDaoImpl extends BaseDao2<UserInfo> implements UserInfoDao {

    @Override
    public UserInfo getUserInfoByUserNameAndPassword(String userName, String password) {
        return selectOne("select * from t_user_info where user_name=? and `password`=?", UserInfo.class,userName,password);
    }

    @Override
    public List<UserInfo> getUserAll() {
        return selectListForObject("select * from t_user_info",UserInfo.class);
    }
}
