package com.web.dao.Impl;

import com.mysql.cj.util.StringUtils;
import com.web.dao.RegisterDao;
import com.web.entity.UserDetailInfo;
import com.web.entity.UserInfo;
import com.web.utils.BaseDao2;

public class RegisterDaoImpl extends BaseDao2<UserInfo> implements RegisterDao {

    @Override
    public boolean register(UserInfo userInfo) {
        String sql = "insert into t_user_info (name,user_name,password,tel,address,id_card,create_time) values(?,?,?,?,?,?,now())";
        int a = executeUpdate(sql,
                userInfo.getName(),
                userInfo.getUserName(),
                userInfo.getPassword(),
                userInfo.getTel(),
                userInfo.getAddress(),
                userInfo.getIdCard()
        );
        return a > 0;
    }

    @Override
    public boolean isCheckUserName(UserInfo userInfo) {
        String sql = "select * from t_user_info where user_name=?";
        UserInfo c = selectOne(sql, UserInfo.class, userInfo.getUserName());
        return c==null;
//        if (c == null || StringUtils.isNullOrEmpty(userInfo.getUserName())) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public boolean register1(UserDetailInfo userDetailInfo) {
        String sql1="insert into t_user_detail_info value(default,?,?,?,?,?,?,?,?,default)";
        int s = executeUpdate(sql1,
                userDetailInfo.getNickName(),
                userDetailInfo.getName(),
                userDetailInfo.getSex(),
                userDetailInfo.getTel(),
                userDetailInfo.getProvince(),
                userDetailInfo.getCity(),
                userDetailInfo.getDistrict(),
                userDetailInfo.getAddress()
        );
        return s > 0;
    }
}
