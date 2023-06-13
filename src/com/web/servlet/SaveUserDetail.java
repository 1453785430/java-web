package com.web.servlet;

import com.google.gson.Gson;
import com.mysql.cj.util.StringUtils;
import com.web.dao.Impl.RegisterDaoImpl;
import com.web.dao.RegisterDao;
import com.web.entity.UserDetailInfo;
import com.web.utils.BaseResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register1.do")
public class SaveUserDetail extends HttpServlet {
    private RegisterDao registerDao = new RegisterDaoImpl();
    Gson gson = new Gson();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        UserDetailInfo userDetailInfo = new UserDetailInfo();
        userDetailInfo.setNickName(req.getParameter("nickName"));
        userDetailInfo.setName(req.getParameter("name"));
        userDetailInfo.setTel(req.getParameter("tel"));
        System.out.println(req.getParameter("province"));
        userDetailInfo.setProvince(req.getParameter("province"));
        userDetailInfo.setCity(req.getParameter("city"));
        userDetailInfo.setDistrict(req.getParameter("district"));
        userDetailInfo.setAddress(req.getParameter("address"));
        userDetailInfo.setSex(Integer.parseInt(req.getParameter("sex")));
        BaseResult result = null;

        if (StringUtils.isNullOrEmpty(userDetailInfo.getNickName()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getName()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getTel()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getProvince()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getCity()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getDistrict()) ||
            StringUtils.isNullOrEmpty(userDetailInfo.getAddress())
        ){
            result = BaseResult.error(200,"字段不能为空!");
            resp.getWriter().write(gson.toJson(result));
        }else {
            if (registerDao.register1(userDetailInfo)){
                result = BaseResult.success();
            }else {
                result = BaseResult.error(200,"字段已经存在!");
            }

            resp.getWriter().write(gson.toJson(result));

        }
    }
}


